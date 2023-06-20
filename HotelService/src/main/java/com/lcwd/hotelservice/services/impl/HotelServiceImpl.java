package com.lcwd.hotelservice.services.impl;
import com.lcwd.hotelservice.entities.Hotel;
import com.lcwd.hotelservice.exceptions.ResourceNotFoundException;
import com.lcwd.hotelservice.repositories.HotelRepository;
import com.lcwd.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String randomHotelId = UUID.randomUUID().toString();
        hotel.setId(randomHotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getSingleHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with this id is not found : "+id));
    }
}
