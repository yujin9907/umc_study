package org.umc.workbook.converter;

import org.umc.workbook.domain.Store;
import org.umc.workbook.dto.StoreDto;

public class StoreConverter {

    public static Store toStore(StoreDto.SaveRequestDto dto) {
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .score(0f)
                .build();
    }

    public static StoreDto.SaveResultDto toResult(Store store) {
        return StoreDto.SaveResultDto.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }
}
