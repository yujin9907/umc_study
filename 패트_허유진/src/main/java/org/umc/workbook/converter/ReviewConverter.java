package org.umc.workbook.converter;

import org.springframework.data.domain.Page;
import org.umc.workbook.domain.Review;
import org.umc.workbook.dto.ReviewDto;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toReview(ReviewDto.saveRequest dto) {
        return Review.builder()
                .body(dto.getBody())
                .score(dto.getScore())
                .build();
    }

    public static ReviewDto.saveResult toPreviewResult(Review review) {
        return ReviewDto.saveResult.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static ReviewDto.ReviewResponseDto toListDto(Page<Review> reviews) {
        List<ReviewDto.ListDto> dtos = reviews.getContent().stream()
                .map(r -> ReviewDto.ListDto.builder()
                        .id(r.getId())
                        .body(r.getBody())
                        .score(r.getScore())
                        .storeName(r.getStore().getName())
                        .createdAt(r.getCreatedAt())
                        .build()
                ).collect(Collectors.toList());

        return ReviewDto.ReviewResponseDto.builder()
                .isLast(reviews.isLast())
                .isFirst(reviews.isFirst())
                .totalPage(reviews.getTotalPages())
                .totalElements(reviews.getTotalElements())
                .listSize(dtos.size())
                .reviewList(dtos)
                .build();
    }
}
