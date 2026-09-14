package com.microservices.learning.external_services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.microservices.learning.entity.Rating;

@FeignClient(name = "Rating-Service")
public interface RatingServices {

    @GetMapping("/ratings/users/{userId}")
    List<Rating> hotelInfo(@PathVariable("userId") String userId);
    
}
