package org.example.uberreviewservice.Adapters;

import org.example.uberreviewservice.Dtos.CreateReviewDto;
import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.services.BookingService;
import org.example.uberreviewservice.services.BookingServiceImpl;
import org.example.uberreviewservice.services.ReviewServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter {

    private final BookingServiceImpl bookingServiceImpl;

    public CreateReviewDtoToReviewAdapterImpl(BookingServiceImpl bookingServiceImpl) {
        this.bookingServiceImpl = bookingServiceImpl;
    }

    @Override
    public Review convertDtoToReview(CreateReviewDto createReviewDto) {
        Booking booking = bookingServiceImpl.getBooking(createReviewDto.getBookingId());
        return Review.builder()
                .booking(booking)
                .content(createReviewDto.getContent())
                .rating(createReviewDto.getRating())
                .build() ;
    }
}
