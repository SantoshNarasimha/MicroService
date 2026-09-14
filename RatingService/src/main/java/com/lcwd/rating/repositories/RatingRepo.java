package com.lcwd.rating.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.rating.Entities.Rating;

/**
 * Spring Data JPA repository for Rating.
 */
@Repository
public interface RatingRepo extends JpaRepository<Rating, String>{
    // Custom Finder Methods
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}