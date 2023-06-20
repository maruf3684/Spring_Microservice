package com.lcwd.hotelservice.repositories;
import com.lcwd.hotelservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
