package org.example.uberreviewservice.repositories;

import org.example.uberreviewservice.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select * from Review r join Booking b on b.review_id = r.id where b.id = :bookId" , nativeQuery = true)
    public Review findReviewByBookId(Long bookId);

    Review findReviewById(Long id);
}
