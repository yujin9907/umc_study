package org.umc.workbook.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.umc.workbook.apiPayload.ApiResponse;
import org.umc.workbook.converter.ReviewConverter;
import org.umc.workbook.converter.StoreConverter;
import org.umc.workbook.domain.Review;
import org.umc.workbook.domain.Store;
import org.umc.workbook.dto.ReviewDto;
import org.umc.workbook.service.ReviewService.ReviewService;

@RestController
@RequestMapping("review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/")
    public ApiResponse<?> saveReview(ReviewDto.saveRequest requestDto) {

        Review review = reviewService.saveReview(requestDto);
        return ApiResponse.onSuccess(ReviewConverter.toResult(review));
    }
}
