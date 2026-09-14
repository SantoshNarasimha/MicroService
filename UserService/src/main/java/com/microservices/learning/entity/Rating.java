package com.microservices.learning.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO class for RatingService API responses - NOT a database entity


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rating {

    private String ratingId;
    private String userId;
    private String feedback;
    private int rating;
    private String hotelId;
    private String name; // Added to match RatingService entity

    private List<Hotel> hotel = new ArrayList<>();
}