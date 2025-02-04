package org.example.uberreviewservice.repositories;

import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    public Booking findByIdAndDriverId(Long bookingId, Long driverId);
    public List<Booking> findByDriverId(Long driverId);
    public List<Booking> findAllByDriverIn(List<Driver> drivers);

    Booking findBookingsById(Long id);
}
