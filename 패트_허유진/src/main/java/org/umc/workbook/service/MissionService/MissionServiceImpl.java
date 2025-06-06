package org.umc.workbook.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umc.workbook.apiPayload.code.ErrorStatus;
import org.umc.workbook.apiPayload.exception.handler.StoreHandler;
import org.umc.workbook.converter.MissionConverter;
import org.umc.workbook.domain.Member;
import org.umc.workbook.domain.Mission;
import org.umc.workbook.domain.Store;
import org.umc.workbook.domain.mapping.MemberMission;
import org.umc.workbook.dto.MissionDto;
import org.umc.workbook.repository.MemberMissionRepository;
import org.umc.workbook.repository.MemberRepository.MemberRepository;
import org.umc.workbook.repository.MissionRepository.MissionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<Mission> getMissionsByStore(Long storeId, int page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        return missionRepository.findAllByStoreId(storeId, pageRequest);
    }

    // 회원의 진행 중 미션 확인
    @Override
    public MissionDto.CursorResponseDto findMissionByMember(Long memberId, Integer lastReward, LocalDateTime lastCreatedAt, Long lastMissionId) {
        int pageSize = 10;

        List<MemberMission> results = missionRepository
                .findMissionByMemberPaging(memberId, lastReward, lastCreatedAt, lastMissionId, pageSize + 1);

        boolean hasNext = results.size() > pageSize;

        if (hasNext) {
            results = results.subList(0, pageSize);
        }

        return MissionDto.CursorResponseDto.builder()
                .hasNext(hasNext)
                .missionList(MissionConverter.toMemberDtoList(results))
                .build();
    }

    @Override
    public MemberMission addMemberMission(MissionDto.addMemberRequest requestDto) {
        MemberMission memberMission = MissionConverter.toMemberMission(requestDto);

        Member member = memberRepository.findById(requestDto.getMemberId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(requestDto.getMissionId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.MEMBER_NOT_FOUND));

        memberMission.setMission(mission);
        memberMission.setMember(member);

        return memberMissionRepository.save(memberMission);

    }
}
