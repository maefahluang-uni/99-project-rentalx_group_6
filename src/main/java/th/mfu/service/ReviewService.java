package th.mfu.service;

import java.util.List;

import th.mfu.dto.ReviewDto;
import th.mfu.model.Review;

public interface ReviewService {

    List<Review> findByDormId(Long dormId);

    Review save(ReviewDto reviewDto);

    void deleteByDormId(Long dormId);
}
