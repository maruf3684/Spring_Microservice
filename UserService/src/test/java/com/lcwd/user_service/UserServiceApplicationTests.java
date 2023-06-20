package com.lcwd.user_service;

import com.lcwd.user_service.dto.Rating;
import com.lcwd.user_service.utils.external.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@Service
@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}

	@Test
	void createRating(){
		Rating rating = Rating.builder().rating("5").userId("").hotelId("").fake_field("").feedback("This is created using feign").build();
        Rating savedRating = ratingService.createRating(rating);
		System.out.println("New rating created");
	}

}
