package org.example.uberreviewservice.controllers;

import org.example.uberreviewservice.Adapters.CreateReviewDtoToReviewAdapter;
import org.example.uberreviewservice.Adapters.CreateReviewDtoToReviewAdapterImpl;
import org.example.uberreviewservice.Dtos.CreateReviewDto;
import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.repositories.BookingRepository;
import org.example.uberreviewservice.repositories.ReviewRepository;
import org.example.uberreviewservice.services.ReviewService;
import org.example.uberreviewservice.services.ReviewServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

//    private final ReviewService reviewService;
    private final ReviewServiceImpl reviewService;
    private final ReviewRepository reviewRepository;
    private final CreateReviewDtoToReviewAdapterImpl createReviewDtoToReviewAdapter;

    public ReviewController(ReviewServiceImpl reviewService, ReviewRepository reviewRepository, CreateReviewDtoToReviewAdapterImpl createReviewDtoToReviewAdapter) {
        this.reviewService = reviewService;
        this.reviewRepository = reviewRepository;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
    }

    @GetMapping("review/{id}")
    public ResponseEntity<Review> getReview(@PathVariable Long id) {
        Review review = reviewService.getReview(id) ;
        return ResponseEntity.status(HttpStatus.FOUND).body(review) ;
    }

    @PostMapping("review")
    public ResponseEntity<?> addReview(@Validated @RequestBody CreateReviewDto createReviewDto) {
        System.out.println("Received Booking ID: " + createReviewDto.getBookingId());

        Review setteledReview = this.createReviewDtoToReviewAdapter.convertDtoToReview(createReviewDto);
        Review review = reviewService.addReview(setteledReview);

        return ResponseEntity.status(HttpStatus.CREATED).body(review) ;
    }

    @GetMapping("review")
    public ResponseEntity<List<Review>> getReviews() {
        List<Review> reviews = reviewService.getReviews() ;
        return ResponseEntity.status(HttpStatus.OK).body(reviews) ;
    }

    @GetMapping("booking/review/{bookingId}")
    public ResponseEntity<Review> getReviewByBooking(@PathVariable Long bookingId) {
        Review review = reviewRepository.findReviewByBookId(bookingId) ;
        return ResponseEntity.status(HttpStatus.FOUND).body(review) ;
    }
}
