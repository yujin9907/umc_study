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
import org.springframework.web.bind.annotation.*;
import org.umc.workbook.apiPayload.ApiResponse;
import org.umc.workbook.converter.ReviewConverter;
import org.umc.workbook.domain.Review;
import org.umc.workbook.dto.ReviewDto;
import org.umc.workbook.service.ReviewService.ReviewService;
import org.umc.workbook.validation.annotation.ValidPage;

@RestController
@RequestMapping("review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/member/{memberId}")
    @Operation(summary = "회원 리뷰 조회", description = "특정 회원이 작성한 리뷰 목록을 조회합니다. (페이징 포함)")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "조회하려는 회원의 ID, path variable 입니다!"),
    })
    public ApiResponse<?> getMemberReviewList(@PathVariable("memberId") Long memberId,
                                               @RequestParam("page") @Valid @ValidPage Integer page
    ) {
        Page<Review> reviews = reviewService.getMemberReviewList(memberId, page);
        return ApiResponse.onSuccess(ReviewConverter.toListDto(reviews));
    }

    @PostMapping("/")
    public ApiResponse<?> saveReview(ReviewDto.saveRequest requestDto) {

        Review review = reviewService.saveReview(requestDto);
        return ApiResponse.onSuccess(ReviewConverter.toPreviewResult(review));
    }
}
