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
//    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings;

    @Column
    private String name;

    @Column
    private String license;
}
