package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.repositories.BookingRepository;
import org.example.uberreviewservice.repositories.DriverRepository;
import org.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.rmi.Remote;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService  implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final  BookingRepository bookingRepository;
    private final DriverRepository driverRepository;
    public ReviewService(ReviewRepository reviewRepository , BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("**********************************");
//        Review r = Review.builder()  // by this line we are creating the object to insert
//                .content("This is a review21")
//                .rating((double) 22)
//                .build();
////        reviewRepository.deleteById(2L);
//        Booking b = Booking.builder()
//                            .startTime(new Date())
//                            .review(r)
//                            .build();
//
////        reviewRepository.save(r);  // since we already use cascade property so no need to explicitly
//                                   // mention which one repository have to be saved first in database
//        bookingRepository.save(b);

//        Booking booking = bookingRepository.findByIdAndDriverId(1L, 1L) ;
//        System.out.println("---->" + booking.getTotalDistance());

        List<Booking> bookings = bookingRepository.findByDriverId(1L) ;
        for (Booking booking : bookings) {
            System.out.println("---> " + booking);
        }

    }
}
