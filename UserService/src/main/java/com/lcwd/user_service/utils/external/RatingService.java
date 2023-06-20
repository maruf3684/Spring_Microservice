package com.lcwd.user_service.utils.external;
import com.lcwd.user_service.dto.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping ("/ratings/users/{userId}")
    public ResponseEntity<List<Rating>> getRating(@PathVariable("userId") String userId);
    @PostMapping("/ratings")
    public Rating createRating(Rating rating);

    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String ratingId ,Rating rating);

    @DeleteMapping ("/ratings/{ratingId}")
    public Rating deleteRating(@PathVariable("ratingId") String ratingId);

}


//class banano na thakle map use kora jaite pare
//public Rating createRating(Map<String,Object> rating);
