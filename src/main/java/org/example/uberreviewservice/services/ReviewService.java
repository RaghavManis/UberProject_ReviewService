package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.rmi.Remote;
@Service
public class ReviewService  implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("**********************************");
        Review r = Review.builder()  // by this line we are creating the object to insert
                .content("This is a review")
                .rating((double) 22)
                .build();
        reviewRepository.save(r);  // now this line will execute the sql query

    }
}
