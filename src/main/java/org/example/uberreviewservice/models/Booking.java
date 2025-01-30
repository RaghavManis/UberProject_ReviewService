package org.example.uberreviewservice.models;

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

    @OneToOne(cascade = CascadeType.PERSIST)
    private Review review;

    @Enumerated(value = EnumType.STRING)
    protected BookingStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date startTine;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTine;

    private int totalDistance;
}
