package com.lcwd.rating.services;

import com.lcwd.rating.Entities.Rating;
import com.lcwd.rating.repositories.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating create(Rating rating) {
        // generate unique rating id
        String randomId = UUID.randomUUID().toString();
        rating.setRatingId(randomId);
        return this.ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return this.ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String UserId) {
        return this.ratingRepo.findByUserId(UserId);
    }

    @Override
    public List<Rating> getAllByHotelId(String HotelId) {
        return this.ratingRepo.findByHotelId(HotelId);
    }
}