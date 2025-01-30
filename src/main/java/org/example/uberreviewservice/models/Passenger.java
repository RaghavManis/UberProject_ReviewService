package org.example.uberreviewservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passenger extends BaseModel {

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings;

    private String name;
}
