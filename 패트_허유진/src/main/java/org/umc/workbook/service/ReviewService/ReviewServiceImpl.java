package org.umc.workbook.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.umc.workbook.domain.Review;
import org.umc.workbook.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }
}
