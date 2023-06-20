package com.lcwd.user_service.dto;

import lombok.*;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private String rating;
    private String fake_field;
    private String feedback;
    private  Hotel hotel;

}
