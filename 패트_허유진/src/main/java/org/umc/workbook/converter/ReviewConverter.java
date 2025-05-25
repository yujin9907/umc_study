package org.umc.workbook.converter;

import org.umc.workbook.domain.Review;
import org.umc.workbook.dto.ReviewDto;

public class ReviewConverter {

    public static Review toReview(ReviewDto.saveRequest dto) {
        return Review.builder()
                .body(dto.getBody())
                .score(dto.getScore())
                .build();
    }

    public static ReviewDto.saveResult toResult(Review review) {
        return ReviewDto.saveResult.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
