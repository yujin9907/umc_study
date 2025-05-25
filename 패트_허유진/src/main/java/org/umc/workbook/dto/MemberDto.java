package org.umc.workbook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.umc.workbook.domain.enums.Gender;
import org.umc.workbook.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberDto {
    @Getter
    public static class JoinDto {
        @NotBlank
        private String name;
        @NotNull
        private Gender gender;
        @NotNull
        private LocalDate birthDate;
        @Size(min = 5, max = 12)
        private String address;
        @Size(min = 5, max = 12)
        private String specAddress;
        // TODO
        // memberstate;
        // social, email
        // point
        @ExistCategories
        List<Long> preferCategory;

    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO {
        Long memberId;
        LocalDateTime createdAt;
    }
}
