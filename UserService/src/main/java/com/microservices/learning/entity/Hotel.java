package com.microservices.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hotel {

    private String hotelId;
    private String hotelName;
    private String location;
    private String about;
    
}
