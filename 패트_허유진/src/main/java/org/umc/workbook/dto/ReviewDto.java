package org.umc.workbook.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewDto {

    @Data
    @Builder
    public static class ListDto {
        private Long id;
        private String body;
        private Float score;
        private String storeName;
        private LocalDateTime createdAt;
    }

    @Data
    @Builder
    public static class PreviewRequestDto {
        private String ownerNickname;
        private Float score;
        private String body;
        LocalDate createdAt;
    }
    @Data
    @Builder
    public static class ReviewResponseDto {
        private boolean isLast;
        private boolean isFirst;
        private Integer totalPage;
        private Long totalElements;
        private Integer listSize;
        private List<?> reviewList;
    }

    @Data
    public static class saveRequest {
        private String body;
        @NotNull
        private Float score;
        @NotNull
        private Long memberId;
        @NotNull
        private Long storeId;
    }

    @Data
    @Builder
    public static class saveResult {
        private Long reviewId;
        private LocalDateTime createdAt;
    }
}
