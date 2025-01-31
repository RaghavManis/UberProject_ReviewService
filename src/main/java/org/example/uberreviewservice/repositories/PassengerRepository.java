package org.example.uberreviewservice.repositories;

import org.example.uberreviewservice.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
