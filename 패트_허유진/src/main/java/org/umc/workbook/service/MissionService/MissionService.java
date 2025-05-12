package org.umc.workbook.service.MissionService;

import org.umc.workbook.domain.Mission;
import org.umc.workbook.dto.MissionDto;

import java.time.LocalDateTime;
import java.util.List;

public interface MissionService {
    List<MissionDto> findMissionByMember(Long memberId, Integer lastReward, LocalDateTime lastCreatedAt, Long lastMissionId);
    List<Mission> findHomeMission(Long missionId, Long memberId);
}
