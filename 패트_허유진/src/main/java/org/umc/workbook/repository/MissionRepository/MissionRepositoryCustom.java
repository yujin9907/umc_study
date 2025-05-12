package org.umc.workbook.repository.MissionRepository;

import org.umc.workbook.domain.Mission;
import org.umc.workbook.domain.mapping.MemberMission;

import java.time.LocalDateTime;
import java.util.List;

public interface MissionRepositoryCustom {

    List<MemberMission> findMissionByMemberPaging(Long memberId, Integer lastReward, LocalDateTime lastCreatedAt, Long lastMissionId);

    List<Mission> findHoneMissionPaging(Long lastMissionId, Long memberId);
}
