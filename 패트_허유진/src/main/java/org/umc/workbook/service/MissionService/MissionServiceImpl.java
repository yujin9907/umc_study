package org.umc.workbook.service.MissionService;

import lombok.RequiredArgsConstructor;
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

    // 회원의 진행 중 미션 확인
    @Override
    public List<MemberMission> findMissionByMember(Long memberId, Integer lastReward, LocalDateTime lastCreatedAt, Long lastMissionId) {
        return missionRepository
                .findMissionByMemberPaging(memberId, lastReward, lastCreatedAt, lastMissionId);
    }

    @Override
    public List<Mission> findHomeMission(Long missionId, Long memberId) {
        return missionRepository.findHoneMissionPaging(missionId, memberId);
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
