package org.umc.workbook.service.ReviewService;

import org.umc.workbook.domain.Review;
import org.umc.workbook.dto.ReviewDto;

public interface ReviewService {

    Review saveReview(ReviewDto.saveRequest review);
}
