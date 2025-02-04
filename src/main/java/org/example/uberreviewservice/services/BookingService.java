package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    public Booking createBooking(Booking booking);
    public Booking getBooking(Long bookingId);
    public List<Booking> findAllBookings();
    public Booking updateBooking(Booking booking);

}
