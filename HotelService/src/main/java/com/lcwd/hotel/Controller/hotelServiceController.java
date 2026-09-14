package com.lcwd.hotel.Controller;

import com.lcwd.hotel.Entities.Hotel;
import com.lcwd.hotel.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class hotelServiceController {

    @Autowired
    private HotelService hotelServ;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    // create hotel
    @PostMapping("/save")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel saving = hotelServ.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(saving);
    }

    //get single hotel
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        Hotel get = hotelServ.getById(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(get);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> getall = hotelServ.getAll();
        return ResponseEntity.ok(getall);
    }
    
}