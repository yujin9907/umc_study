package org.umc.workbook.service.MissionService;

import org.springframework.data.domain.Page;
import org.umc.workbook.domain.Mission;
import org.umc.workbook.domain.mapping.MemberMission;
import org.umc.workbook.dto.MissionDto;

import java.time.LocalDateTime;
import java.util.List;

public interface MissionService {
    Page<Mission> getMissionsByStore(Long storeId, int page);
    List<MemberMission> findMissionByMember(Long memberId, Integer lastReward, LocalDateTime lastCreatedAt, Long lastMissionId);
    MemberMission addMemberMission(MissionDto.addMemberRequest requestDto);
}
