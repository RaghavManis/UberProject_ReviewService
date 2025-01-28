package org.example.uberreviewservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    Long id; // Recommended for JPA entities due to its ability to hold null values.
}
