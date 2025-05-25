package org.umc.workbook.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.umc.workbook.apiPayload.ApiResponse;
import org.umc.workbook.converter.StoreConverter;
import org.umc.workbook.domain.Store;
import org.umc.workbook.dto.StoreDto;
import org.umc.workbook.service.StoreService.StoreQueryService;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreQueryService storeService;

    @PostMapping("/")
    public ApiResponse<?> saveStore(StoreDto.SaveRequestDto requestDto) {
        Store store = storeService.saveStore(requestDto);
        return ApiResponse.onSuccess(StoreConverter.toResult(store));
    }
}
