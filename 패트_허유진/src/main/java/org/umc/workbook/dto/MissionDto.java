package org.umc.workbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.umc.workbook.domain.Mission;
import org.umc.workbook.domain.Store;
import org.umc.workbook.domain.enums.MissionStatus;
import org.umc.workbook.domain.mapping.MemberMission;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class MissionDto {

    @Builder
    @Data
    public static class StoreList {
        private Long id;
        private String missionSpec;
        private Integer reward;
        private LocalDateTime deadline;
    }
    @Data
    @Builder
    public static class ResponseDto {
        private boolean isLast;
        private boolean isFirst;
        private Integer totalPage;
        private Long totalElements;
        private Integer listSize;
        private List<?> missionList;
    }

    @Builder
    @Data
    public static class MemberList {
        private Long id;
        private Integer reward;
        private String missionSpec;
        private MissionStatus status;
        private Long memberId;
        private StoreDto storeDto;
    }

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
