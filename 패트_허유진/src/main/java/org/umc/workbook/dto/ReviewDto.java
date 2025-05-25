package org.umc.workbook.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.umc.workbook.domain.Member;
import org.umc.workbook.domain.ReviewImage;
import org.umc.workbook.domain.Store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReviewDto {

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
