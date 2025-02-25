package org.example.uberreviewservice.repositories;

import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

//    Driver findDriverById(long id);
    List<Driver> findAllByIdIn(List<Long> driverIds);

    Driver getDriverById(Long id);
}
