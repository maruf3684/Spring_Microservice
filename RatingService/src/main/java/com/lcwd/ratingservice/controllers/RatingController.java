package com.lcwd.ratingservice.controllers;
import com.lcwd.ratingservice.entities.Rating;
import com.lcwd.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;
    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService=ratingService;
    }


    @PostMapping
    public ResponseEntity<Rating>createRating(@RequestBody Rating rating){
        Rating new_rating=ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(new_rating);
    }

    @GetMapping
    public ResponseEntity<List<Rating>>getAllRating(){
        List<Rating> ratings =ratingService.getAllRating();
        return ResponseEntity.status(HttpStatus.CREATED).body(ratings);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>>getAllRatingByUserId(@PathVariable String userId){
        List<Rating> ratings =ratingService.getRatingByUserId(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratings);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>>getAllRating(@PathVariable String hotelId){
        List<Rating> ratings =ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratings);
    }
}
