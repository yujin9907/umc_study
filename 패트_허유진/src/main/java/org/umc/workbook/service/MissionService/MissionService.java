package org.umc.workbook.service.MissionService;

import org.umc.workbook.domain.Mission;
import org.umc.workbook.domain.mapping.MemberMission;

import java.time.LocalDateTime;
import java.util.List;

public interface MissionService {
    List<MemberMission> findMissionByMember(Long memberId, Integer lastReward, LocalDateTime lastCreatedAt, Long lastMissionId);
    List<Mission> findHomeMission(Long missionId, Long memberId);
}
