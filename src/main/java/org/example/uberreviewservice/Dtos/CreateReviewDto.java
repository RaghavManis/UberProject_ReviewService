package org.example.uberreviewservice.Dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CreateReviewDto {
    private String content;
    private Double rating;
    private Long bookingId;  // Ensure this field is named correctly
}

