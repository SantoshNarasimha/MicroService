package com.microservices.learning.external_services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.microservices.learning.entity.Hotel;

@FeignClient(name = "Hotel-Service")
public interface HotelService {

    @GetMapping("/hotel/{hotelId}")
    Hotel hotelInfo(@PathVariable("hotelId") String hotelId);

    @PostMapping("/hotel/save")
    Hotel hotelSave(@ModelAttribute Hotel hotel);
    
}