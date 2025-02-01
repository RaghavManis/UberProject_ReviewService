package org.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends BaseModel {

    @OneToMany(mappedBy = "driver" , fetch = FetchType.LAZY)
    // instead of using this(SUBSELECT) we van also use fetch as eager and our work will be done in a single query but
    // if we do that then it is not necessary that we always need eager manner , we need eager manner at only some
    // places then due to one need only why we disturb all the needs by increasing their executing time and memory
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings;

    @Column
    private String name;

    @Column
    private String license;
}
