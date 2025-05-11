package org.umc.workbook.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.umc.workbook.domain.Member;
import org.umc.workbook.repository.MemberRepository.MemberRepository;
import org.umc.workbook.service.MemberService.MemberService;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("멤버 조회 불가"));
    }
}
