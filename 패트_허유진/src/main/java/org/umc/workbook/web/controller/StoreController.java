package org.umc.workbook.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.umc.workbook.apiPayload.ApiResponse;
import org.umc.workbook.converter.StoreConverter;
import org.umc.workbook.domain.Review;
import org.umc.workbook.domain.Store;
import org.umc.workbook.dto.StoreDto;
import org.umc.workbook.service.StoreService.StoreQueryService;
import org.umc.workbook.validation.annotation.ExistCategories;
import org.umc.workbook.validation.annotation.ExistStore;

import java.util.List;

@RestController
@RequestMapping("store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreQueryService storeService;

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
    })
    public ApiResponse<?> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page) {
        Page<Review> reviews = storeService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviews));
    }

    @PostMapping("/")
    public ApiResponse<?> saveStore(StoreDto.SaveRequestDto requestDto) {
        Store store = storeService.saveStore(requestDto);
        return ApiResponse.onSuccess(StoreConverter.toResult(store));
    }
}
