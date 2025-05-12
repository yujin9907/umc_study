package org.umc.workbook.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umc.workbook.converter.MissionConverter;
import org.umc.workbook.domain.Mission;
import org.umc.workbook.dto.MissionDto;
import org.umc.workbook.repository.MissionRepository.MissionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;

    // 회원의 진행 중 미션 확인
    @Override
    public List<MissionDto> findMissionByMember(Long memberId, Integer lastReward, LocalDateTime lastCreatedAt, Long lastMissionId) {
        List<MissionDto> missions = missionRepository
                .findMissionByMemberPaging(memberId, lastReward, lastCreatedAt, lastMissionId)
                .stream().map(m -> MissionConverter.toDto(m, m.getMission().getStore(),
                        m.getMission(), m.getMember())).collect(Collectors.toList());

        return missions;
    }

    @Override
    public List<Mission> findHomeMission(Long missionId, Long memberId) {
        return missionRepository.findHoneMissionPaging(missionId, memberId);
    }

}
