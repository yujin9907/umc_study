package org.umc.workbook.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umc.workbook.domain.Mission;
import org.umc.workbook.domain.mapping.MemberMission;
import org.umc.workbook.repository.MissionRepository.MissionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;

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

}
