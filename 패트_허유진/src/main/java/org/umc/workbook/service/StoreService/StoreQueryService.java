package org.umc.workbook.service.StoreService;

import org.umc.workbook.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoreByNameAndScore(String name, Float score);
}
