package com.lcwd.rating.services;

import java.util.List;

import com.lcwd.rating.Entities.Rating;



public interface RatingService{

    Rating create(Rating rating);

    // get all 
    List<Rating> getAll();

    // get specific user ratings details
    List<Rating> getRatingsByUserId(String UserId);

    // get specific hotel rating details
    List<Rating> getAllByHotelId(String HotelId);

}