package org.umc.workbook.converter;

import org.umc.workbook.domain.Member;
import org.umc.workbook.domain.Mission;
import org.umc.workbook.domain.Store;
import org.umc.workbook.domain.enums.MissionStatus;
import org.umc.workbook.domain.mapping.MemberMission;
import org.umc.workbook.dto.MissionDto;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static List<MissionDto> toMissionByMember(List<MemberMission> missions){
        return missions.stream().map(m -> MissionConverter.toDto(m, m.getMission().getStore(),
                m.getMission(), m.getMember())).collect(Collectors.toList());

    }

    private static MissionDto toDto(MemberMission memberMission, Store store,
                                   Mission mission, Member member) {
        MissionDto.StoreDto storeDto = MissionDto.StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .build();

        return MissionDto.builder()
                .id(memberMission.getId())
                .status(memberMission.getStatus())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .memberId(member.getId())
                .storeDto(storeDto)
                .build();
    }

    public static Mission toEntity(MissionDto dto) {
        return null;
    }
}
