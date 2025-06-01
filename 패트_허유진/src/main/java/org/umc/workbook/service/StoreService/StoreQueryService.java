package org.umc.workbook.service.StoreService;

import org.springframework.data.domain.Page;
import org.umc.workbook.domain.Review;
import org.umc.workbook.domain.Store;
import org.umc.workbook.dto.StoreDto;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Page<Review> getReviewList(Long StoreId, Integer page);


    Optional<Store> findStore(Long id);
    List<Store> findStoreByNameAndScore(String name, Float score);

    Store saveStore(StoreDto.SaveRequestDto dto);

}
