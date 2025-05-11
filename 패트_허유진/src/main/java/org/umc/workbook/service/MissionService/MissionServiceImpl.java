package org.umc.workbook.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.umc.workbook.domain.Mission;
import org.umc.workbook.repository.MissionRepository.MissionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;

    @Override
    public List<Mission> findMissionByMember(Long memberId, Integer lastReward, LocalDateTime lastCreatedAt, Long lastMissionId) {
        List<Mission> missions = missionRepository.findMissionByMemberPaging(memberId, lastReward, lastCreatedAt, lastMissionId);

        return missions;
    }

    @Override
    public List<Mission> findHomeMission(Long missionId, Long memberId) {
        return missionRepository.findHoneMissionPaging(missionId, memberId);
    }

}
