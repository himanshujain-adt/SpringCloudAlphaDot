package com.alpha.rating.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ST_RATINGS")
public class Ratings {

	@Id
	private String ratingId;

	private String userId;

	private String hotelId;

	private Integer rating;

	private String feedback;
	

}