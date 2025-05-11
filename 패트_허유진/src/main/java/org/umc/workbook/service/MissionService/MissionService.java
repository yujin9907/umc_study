package org.umc.workbook.service.MissionService;

import org.umc.workbook.domain.Mission;

import java.time.LocalDateTime;
import java.util.List;

public interface MissionService {
    List<Mission> findMissionByMember(Long memberId, Integer lastReward, LocalDateTime lastCreatedAt, Long lastMissionId);
    List<Mission> findHomeMission(Long missionId, Long memberId);
}
