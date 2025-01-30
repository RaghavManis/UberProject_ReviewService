package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.repositories.BookingRepository;
import org.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.rmi.Remote;
import java.util.Date;

@Service
public class ReviewService  implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final  BookingRepository bookingRepository;
    public ReviewService(ReviewRepository reviewRepository , BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("**********************************");
        Review r = Review.builder()  // by this line we are creating the object to insert
                .content("This is a review21")
                .rating((double) 22)
                .build();
//        reviewRepository.deleteById(2L);
        Booking b = Booking.builder()
                            .startTime(new Date())
                            .review(r)
                            .build();

//        reviewRepository.save(r);  // since we already use cascade property so no need to explicitly
                                   // mention which one repository have to be saved first in database
        bookingRepository.save(b);

    }
}
