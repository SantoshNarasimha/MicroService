package com.lcwd.hotel.Service;

import com.lcwd.hotel.Entities.Hotel;
import com.lcwd.hotel.Exceptions.ResourceNotFoundException;
import com.lcwd.hotel.Repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepo;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setHotelId(id);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {

        return hotelRepo.findAll();
        
    }

    @Override
    public Hotel getById(String hotelId) {

        return hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("hotel with given id is not found! " + hotelId));
        
    }
}