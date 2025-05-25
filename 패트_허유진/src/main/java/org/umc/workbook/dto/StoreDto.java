package org.umc.workbook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.umc.workbook.domain.Region;
import org.umc.workbook.domain.StoreType;

import java.time.LocalDateTime;

public class StoreDto {

    @Data
    public static class SaveRequestDto {
        @NotBlank
        private String name;
        @Size(min = 5, max = 10)
        private String address;
        @NotNull
        private int startTime;
        @NotNull
        private int endTime;
        @NotNull
        private Long typeId;
        @NotNull
        private Long regionId;
    }

    @Data
    @Builder
    public static class SaveResultDto {
        private Long storeId;
        private LocalDateTime createdAt;
    }
}
