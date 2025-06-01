package org.umc.workbook.converter;

import org.springframework.data.domain.Page;
import org.umc.workbook.domain.Member;
import org.umc.workbook.domain.Mission;
import org.umc.workbook.domain.Store;
import org.umc.workbook.domain.mapping.MemberMission;
import org.umc.workbook.dto.MissionDto;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    private static MissionDto.StoreList toStoreDto(Mission mission) {
        return MissionDto.StoreList.builder()
                .id(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }

    public static MissionDto.ResponseDto toStoreResponseDto(Page<Mission> missions) {
        List<MissionDto.StoreList> missionContents = missions.getContent().stream()
                .map(MissionConverter::toStoreDto).collect(Collectors.toList());

        return MissionDto.ResponseDto.builder()
                .isLast(missions.isLast())
                .isFirst(missions.isFirst())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .listSize(missionContents.size())
                .missionList(missionContents)
                .build();
    }

    public static List<MissionDto.MemberList> toMemberDtoList(List<MemberMission> missions){
        return missions.stream().map(MissionConverter::toMemberDto).toList();
    }

    private static MissionDto.MemberList toMemberDto(MemberMission memberMission) {
        return MissionDto.MemberList.builder()
                .id(memberMission.getId())
                .status(memberMission.getStatus())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .reward(memberMission.getMission().getReward())
                .memberId(memberMission.getMission().getId())
                .build();
    }

    public static MemberMission toMemberMission(MissionDto.addMemberRequest requestDto) {
        return MemberMission.builder()
                .status(requestDto.getStatus())
                .build();
    }

    public static MissionDto.addMemberResult toMemberMissionDto(MemberMission memberMission) {
        return MissionDto.addMemberResult.builder()
                .memberMissionId(memberMission.getId())
                .status(memberMission.getStatus())
                .createAt(memberMission.getCreatedAt())
                .build();
    }
}
