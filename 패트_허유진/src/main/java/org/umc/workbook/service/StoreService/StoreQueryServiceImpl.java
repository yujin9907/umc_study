package org.umc.workbook.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umc.workbook.apiPayload.code.ErrorStatus;
import org.umc.workbook.apiPayload.exception.handler.StoreHandler;
import org.umc.workbook.converter.StoreConverter;
import org.umc.workbook.domain.Region;
import org.umc.workbook.domain.Review;
import org.umc.workbook.domain.Store;
import org.umc.workbook.domain.StoreType;
import org.umc.workbook.dto.StoreDto;
import org.umc.workbook.repository.RegionRepository;
import org.umc.workbook.repository.ReviewRepository.ReviewRepository;
import org.umc.workbook.repository.StoreRepository.StoreRepository;
import org.umc.workbook.repository.StoreTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final StoreTypeRepository storeTypeRepository;
    private final RegionRepository regionRepository;

    private final ReviewRepository reviewRepository;


    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        int pageLimit = Math.max(page - 1, 0);
        PageRequest pageRequest = PageRequest.of(pageLimit, 10);
        Page<Review> StorePage = reviewRepository.findAllByStore(store, pageRequest);
        return StorePage;
    }

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoreByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }

    @Override
    @Transactional
    public Store saveStore(StoreDto.SaveRequestDto dto) {
        Store newStore = StoreConverter.toStore(dto);

        Region region = regionRepository.findById(dto.getRegionId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.REGION_NOT_FOUND));
        StoreType type = storeTypeRepository.findById(dto.getRegionId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_TYPE_NOT_FOUND));

        newStore.setType(type);
        newStore.setRegion(region);

        return storeRepository.save(newStore);

    }
}
