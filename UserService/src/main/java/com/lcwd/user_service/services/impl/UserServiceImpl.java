package com.lcwd.user_service.services.impl;
import com.lcwd.user_service.dto.Hotel;
import com.lcwd.user_service.dto.Rating;
import com.lcwd.user_service.entities.User;
import com.lcwd.user_service.exceptions.ResourceNotFoundException;
import com.lcwd.user_service.repositories.UserRepository;
import com.lcwd.user_service.services.UserService;
import com.lcwd.user_service.utils.external.HotelService;
import com.lcwd.user_service.utils.external.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private RatingService ratingService;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with this id is not found : "+userId));
        ResponseEntity<List<Rating>> ratingOfUser = ratingService.getRating(userId);
        List<Rating> ratingList = ratingOfUser.getBody().stream().map(rating->{
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }


    //Api call using restTemplate
    //    @Override
    //    public User getUser(String userId) {
    //        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with this id is not found : "+userId));
    //        ResponseEntity<List<Rating>> ratingOfUser = restTemplate.exchange(
    //                "http://RATING-SERVICE/ratings/users/" + user.getUserId(),
    //                HttpMethod.GET,
    //                null,
    //                new ParameterizedTypeReference<List<Rating>>() {}
    //        );
    //        List<Rating> ratingList = ratingOfUser.getBody().stream().map(rating->{
    //            ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
    //            Hotel hotel = forEntity.getBody();
    //            rating.setHotel(hotel);
    //            return rating;
    //        }).collect(Collectors.toList());
    //        user.setRatings(ratingList);
    //        return user;
    //    }

}
