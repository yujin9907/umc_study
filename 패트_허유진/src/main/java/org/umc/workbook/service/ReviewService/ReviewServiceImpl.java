package org.umc.workbook.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.umc.workbook.apiPayload.code.ErrorStatus;
import org.umc.workbook.apiPayload.exception.handler.ReviewHandler;
import org.umc.workbook.apiPayload.exception.handler.StoreHandler;
import org.umc.workbook.converter.ReviewConverter;
import org.umc.workbook.domain.Member;
import org.umc.workbook.domain.Review;
import org.umc.workbook.domain.Store;
import org.umc.workbook.dto.ReviewDto;
import org.umc.workbook.repository.MemberRepository.MemberRepository;
import org.umc.workbook.repository.ReviewRepository.ReviewRepository;
import org.umc.workbook.repository.StoreRepository.StoreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public Page<Review> getMemberReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ReviewHandler(ErrorStatus.MEMBER_NOT_FOUND));

        PageRequest pageable = PageRequest.of(page, 10, Sort.by("createdAt").descending());
        return reviewRepository.findAllByMember(member, pageable);
    }

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
