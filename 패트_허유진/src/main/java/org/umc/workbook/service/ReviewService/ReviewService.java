package org.umc.workbook.service.ReviewService;

import org.springframework.data.domain.Page;
import org.umc.workbook.domain.Review;
import org.umc.workbook.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    Page<Review> getMemberReviewList(Long memberId, Integer page);
    Review saveReview(ReviewDto.saveRequest review);
}
