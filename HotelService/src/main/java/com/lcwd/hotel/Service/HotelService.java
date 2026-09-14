package com.lcwd.hotel.Service;

import com.lcwd.hotel.Entities.Hotel;
import java.util.List;

public interface HotelService {

    // create
    Hotel createHotel(Hotel hotel);

    // get all
    List<Hotel> getAll();

    // get by id
    Hotel getById(String id);
}