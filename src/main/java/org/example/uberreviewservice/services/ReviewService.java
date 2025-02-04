package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    public Review getReview(Long id);
    public List<Review> getReviews();
    public Review addReview(Review review);
    public Review updateReview(Review review);
    public void deleteReview(int id);
    public void deleteReviews();

}
