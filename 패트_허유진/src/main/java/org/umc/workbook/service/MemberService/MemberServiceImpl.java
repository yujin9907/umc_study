package org.umc.workbook.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umc.workbook.apiPayload.code.ErrorStatus;
import org.umc.workbook.apiPayload.exception.handler.FoodCategoryHandler;
import org.umc.workbook.converter.MemberConverter;
import org.umc.workbook.converter.MemberPreferConverter;
import org.umc.workbook.domain.FoodCategory;
import org.umc.workbook.domain.Member;
import org.umc.workbook.domain.mapping.MemberPrefer;
import org.umc.workbook.dto.MemberDto;
import org.umc.workbook.repository.FoodCategoryRepository;
import org.umc.workbook.repository.MemberRepository.MemberRepository;
import org.umc.workbook.service.MemberService.MemberService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("멤버 조회 불가"));
    }

    @Override
    @Transactional
    public Member joinMember(MemberDto.JoinDto request) {
        Member member = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(member);});

        return memberRepository.save(member);
    }
}
