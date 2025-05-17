package org.umc.workbook.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.umc.workbook.apiPayload.ApiResponse;
import org.umc.workbook.converter.MissionConverter;
import org.umc.workbook.domain.mapping.MemberMission;
import org.umc.workbook.service.MissionService.MissionService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @GetMapping("member/{memberId}")
    public ApiResponse<?> findMissionByMember(@PathVariable("memberId") Long memberId,
                                              @RequestParam("reward") Integer reward,
                                              @RequestParam("createdAt") @DateTimeFormat(pattern = "yyyyMMddHHmmss")LocalDateTime createdAt,
                                              @RequestParam("missionId") Long missionId) {
        List<MemberMission> missions = missionService.findMissionByMember(memberId, reward, createdAt, missionId);

        return ApiResponse.onSuccess(MissionConverter.toMissionByMember(missions));

    }

}
