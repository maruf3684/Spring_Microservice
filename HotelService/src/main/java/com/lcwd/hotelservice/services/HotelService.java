package com.lcwd.hotelservice.services;

import com.lcwd.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotel();
    Hotel getSingleHotel(String id);

}
