package org.umc.workbook.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.umc.workbook.apiPayload.ApiResponse;
import org.umc.workbook.converter.MissionConverter;
import org.umc.workbook.domain.Mission;
import org.umc.workbook.domain.mapping.MemberMission;
import org.umc.workbook.dto.MissionDto;
import org.umc.workbook.service.MissionService.MissionService;
import org.umc.workbook.validation.annotation.ValidPage;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;


    @GetMapping("store/{storeId}")
    @Operation(summary = "특정 가게의 미션 목록 조회 API")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "조회하려는 가게의 ID, path variable 입니다!"),
    })
    public ApiResponse<?> getMissionsByStore(@PathVariable(name = "storeId") Long storeId,
                                             @Valid @ValidPage @RequestParam("page") Integer page) {
        Page<Mission> result = missionService.getMissionsByStore(storeId, page);
        return ApiResponse.onSuccess(MissionConverter.toStoreResponseDto(result));
    }

    @GetMapping("member/{memberId}")
    public ApiResponse<?> findMissionByMember(@PathVariable("memberId") Long memberId,
                                              @RequestParam("reward") Integer reward,
                                              @RequestParam("createdAt") @DateTimeFormat(pattern = "yyyyMMddHHmmss") LocalDateTime createdAt,
                                              @RequestParam("missionId") Long missionId) {
        List<MemberMission> missions = missionService.findMissionByMember(memberId, reward, createdAt, missionId);

        return ApiResponse.onSuccess(MissionConverter.toMissionByMember(missions));

    }


    @PutMapping("active")
    public ApiResponse<?> addMemberMission(MissionDto.addMemberRequest requestDto) {
        MemberMission memberMission = missionService.addMemberMission(requestDto);
        return ApiResponse.onSuccess(MissionConverter.toMemberMissionDto(memberMission));
    }
}
