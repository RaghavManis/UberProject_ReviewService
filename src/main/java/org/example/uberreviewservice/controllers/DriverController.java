package org.example.uberreviewservice.controllers;

import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Driver;
import org.example.uberreviewservice.services.BookingServiceImpl;
import org.example.uberreviewservice.services.DriverServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {

    DriverServiceImpl driverService;
    BookingServiceImpl bookingService;
    public DriverController(DriverServiceImpl driverService, BookingServiceImpl bookingService) {
        this.driverService = driverService;
        this.bookingService = bookingService;
    }

    @GetMapping("driver")
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> driverList = driverService.getDrivers() ;
        return ResponseEntity.status(HttpStatus.OK).body(driverList);
    }

    @GetMapping("driver/{driverId}")
    public ResponseEntity<Driver> getDriver(@PathVariable Long driverId) {
        Driver driver = driverService.getDriver(driverId) ;
        return ResponseEntity.status(HttpStatus.OK).body(driver);
    }

    @PostMapping("driver")
    public ResponseEntity<?> addDriver(@RequestBody Driver driver) {
        driverService.addDriver(driver);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @PostMapping("driver/booking/{driverId}")
//    public ResponseEntity<?> addBooking(@PathVariable Long driverId , @RequestBody Booking booking) {
//        Driver driver = driverService.getDriver(driverId) ;
//        bookingService.createBooking(booking) ;
//        booking.setDriver(driver);
//        Booking savedBooking = bookingService.createBooking(booking) ;
//        return ResponseEntity.status(HttpStatus.CREATED).body(booking);
//    }
    @PostMapping("driver/booking/{driverId}")
    public ResponseEntity<?> addBooking(@PathVariable Long driverId, @RequestBody Booking booking) {
        Driver driver = driverService.getDriver(driverId);
        if (driver == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Driver not found");
        }
        booking.setDriver(driver);
        Booking savedBooking = bookingService.createBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
    }


    @DeleteMapping("driver")
    public ResponseEntity<?> deleteDrivers() {
        driverService.deleteDrivers();
        return ResponseEntity.status(HttpStatus.OK).build() ;
    }

    @DeleteMapping("driver/{driverId}")
    public ResponseEntity<?> deleteDriver(@PathVariable Long driverId) {
        driverService.deleteDriver(driverId);
        return ResponseEntity.status(HttpStatus.OK).build() ;
    }

}
