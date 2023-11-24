package th.mfu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.mfu.dto.ReviewDto;
import th.mfu.model.Review;
import th.mfu.repository.ReviewRepository;
import th.mfu.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
    private Long reviewId = 11L;
    
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> findByDormId(Long dormId) {
        return reviewRepository.findByDormId(dormId);
    }

    @Override
    public Review save(ReviewDto reviewDto) {
        Review review = new Review(reviewId,reviewDto.getUser(),reviewDto.getDorm(),reviewDto.getRating(),reviewDto.getReviewFromUser(),reviewDto.getTimestamp());
        reviewId++;
        return reviewRepository.save(review);
    }

    @Override
    public void deleteByDormId(Long dormId) {
        reviewRepository.deleteByDormId(dormId);
    }
    
}
