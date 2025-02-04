package org.example.uberreviewservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends BaseModel {

    @ManyToOne( fetch = FetchType.LAZY)
//    @JsonBackReference
    private Driver driver;

    @ManyToOne(cascade = {CascadeType.PERSIST , CascadeType.REMOVE} , fetch = FetchType.LAZY)
//    @JsonBackReference
    private Passenger passenger;

    @Enumerated(value = EnumType.STRING)
    protected BookingStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    private int totalDistance;
}
