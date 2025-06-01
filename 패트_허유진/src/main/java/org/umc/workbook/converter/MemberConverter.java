package org.umc.workbook.converter;

import org.umc.workbook.domain.Member;
import org.umc.workbook.domain.enums.Gender;
import org.umc.workbook.dto.MemberDto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {


    public static MemberDto.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberDto.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberDto.JoinDto request) {

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(request.getGender())
                .name(request.getName())
                .preferences(new ArrayList<>())
                .build();
    }
}