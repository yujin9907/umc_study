package org.umc.workbook.converter;

import org.springframework.data.domain.Page;
import org.umc.workbook.domain.Review;
import org.umc.workbook.domain.Store;
import org.umc.workbook.dto.ReviewDto;
import org.umc.workbook.dto.StoreDto;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static ReviewDto.PreviewDto reviewPreViewDTO(Review review){
        return ReviewDto.PreviewDto.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static ReviewDto.ReviewResponseDto reviewPreViewListDTO(Page<Review> reviewList){
        List<ReviewDto.PreviewDto> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());
        return ReviewDto.ReviewResponseDto.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }


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
