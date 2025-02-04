package org.example.uberreviewservice.Adapters;

import org.example.uberreviewservice.Dtos.CreateReviewDto;
import org.example.uberreviewservice.models.Review;
import org.springframework.stereotype.Component;

@Component
public interface CreateReviewDtoToReviewAdapter {
    public Review convertDtoToReview(CreateReviewDto createReviewDto);
}
