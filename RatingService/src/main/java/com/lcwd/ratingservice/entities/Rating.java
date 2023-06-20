package com.lcwd.ratingservice.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "micro_ratings")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private String rating;
    private String feedback;

}