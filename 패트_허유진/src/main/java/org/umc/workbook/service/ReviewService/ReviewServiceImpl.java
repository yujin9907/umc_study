package org.umc.workbook.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umc.workbook.apiPayload.code.ErrorStatus;
import org.umc.workbook.apiPayload.exception.handler.StoreHandler;
import org.umc.workbook.converter.ReviewConverter;
import org.umc.workbook.domain.Member;
import org.umc.workbook.domain.Review;
import org.umc.workbook.domain.Store;
import org.umc.workbook.dto.ReviewDto;
import org.umc.workbook.repository.MemberRepository.MemberRepository;
import org.umc.workbook.repository.ReviewRepository.ReviewRepository;
import org.umc.workbook.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review saveReview(ReviewDto.saveRequest dto) {
        Review newReview = ReviewConverter.toReview(dto);

        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        newReview.setMember(member);
        newReview.setStore(store);

        return reviewRepository.save(newReview);
    }
}
