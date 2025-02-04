package org.example.uberreviewservice.controllers;

import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.repositories.BookingRepository;
import org.example.uberreviewservice.repositories.ReviewRepository;
import org.example.uberreviewservice.services.BookingService;
import org.example.uberreviewservice.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    BookingService bookingService;
    ReviewService reviewService;
    private final BookingRepository bookingRepository;
    private final ReviewRepository reviewRepository;

    public BookingController(BookingService bookingService,
                             BookingRepository bookingRepository, ReviewService reviewService,
                             ReviewRepository reviewRepository) {
        this.bookingService = bookingService;
        this.bookingRepository = bookingRepository;
        this.reviewService = reviewService;
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("booking")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        System.out.println(" ---> " + booking.getDriver());
        bookingService.createBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(booking);
    }

//    @PostMapping("booking/review/{bookingId}")
//    public ResponseEntity<?> createReview(@PathVariable Long bookingId, @RequestBody Review review) {
//        Booking booking = bookingService.getBooking(bookingId);
//        if (booking == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//        reviewRepository.save(review); // Save the review first
//
//        booking.setReview(review);  // Set the review on the booking
//
//        bookingService.updateBooking(booking); // Use an UPDATE method, not create
//
//        System.out.println("------------>" + booking.getReview());
//        System.out.println("------------>" + booking.getReview().getRating());
//        System.out.println("------------>" + booking.getReview().getContent());
//
//        return ResponseEntity.status(HttpStatus.OK).body(booking); // Return 200 OK on successful update
//    }


    @GetMapping("booking")
    public ResponseEntity<List<Booking>> getAllBookings() {
        System.out.println("---------- controller getmapping" );
        List<Booking> bookings = bookingService.findAllBookings();
        System.out.println("--------controller after calling findAllBookings" );
        return ResponseEntity.status(HttpStatus.OK).body(bookings);
    }

    @GetMapping("booking/{bookingId}")
    public ResponseEntity<?> getBooking(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBooking(bookingId);
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

}
