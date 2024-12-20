package com.alpha.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alpha.user.entites.Rating;
import com.alpha.user.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	
	  @Test void contextLoads() { }
	 

	@Autowired
	private RatingService ratingService;

	@Test
	void createRating() {
		Rating rating = Rating.builder().rating(10).build();
		Rating saveRating = ratingService.createRating(rating);
		System.out.println("New Rating Created");
	}

}
