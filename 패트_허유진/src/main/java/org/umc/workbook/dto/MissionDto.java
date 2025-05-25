package org.umc.workbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.umc.workbook.domain.Mission;
import org.umc.workbook.domain.Store;
import org.umc.workbook.domain.enums.MissionStatus;
import org.umc.workbook.domain.mapping.MemberMission;

import java.time.LocalDateTime;

@Builder
@Data
public class MissionDto {
    private Long id;
    private Integer reward;
    private String missionSpec;
    private MissionStatus status;
    private Long memberId;
    private StoreDto storeDto;

    @Builder
    @Data
    public static class StoreDto {
        private Long id;
        private String name;
    }

    @Data
    public static class addMemberRequest {
        private Long memberId;
        private Long missionId;
        private MissionStatus status;
    }


    @Data
    @Builder
    public static class addMemberResult {
        private Long memberMissionId;
        private MissionStatus status;
        private LocalDateTime createAt;
    }


}
