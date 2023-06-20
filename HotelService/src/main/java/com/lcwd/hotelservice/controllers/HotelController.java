package com.lcwd.hotelservice.controllers;
import com.lcwd.hotelservice.entities.Hotel;
import com.lcwd.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel newHotel = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotel);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId){
        Hotel hotel = hotelService.getSingleHotel(hotelId);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        List<Hotel> hotels = hotelService.getAllHotel();
        return ResponseEntity.ok(hotels);
    }
}
