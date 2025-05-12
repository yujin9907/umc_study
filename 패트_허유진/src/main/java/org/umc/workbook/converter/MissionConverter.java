package org.umc.workbook.converter;

import org.umc.workbook.domain.Member;
import org.umc.workbook.domain.Mission;
import org.umc.workbook.domain.Store;
import org.umc.workbook.domain.enums.MissionStatus;
import org.umc.workbook.domain.mapping.MemberMission;
import org.umc.workbook.dto.MissionDto;

public class MissionConverter {

    public static MissionDto toDto(MemberMission memberMission, Store store,
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
