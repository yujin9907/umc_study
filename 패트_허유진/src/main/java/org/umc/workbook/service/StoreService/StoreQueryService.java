package org.umc.workbook.service.StoreService;

import org.umc.workbook.domain.Store;
import org.umc.workbook.dto.StoreDto;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoreByNameAndScore(String name, Float score);

    Store saveStore(StoreDto.SaveRequestDto dto);
}
