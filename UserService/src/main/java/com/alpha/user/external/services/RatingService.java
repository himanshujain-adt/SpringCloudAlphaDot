package com.alpha.user.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.alpha.user.entites.Rating;

//@Service
@FeignClient(name = "RATING-MIRCO-SERVICE")
public interface RatingService {

	// post
	@PostMapping("/ratings/save")
	public Rating createRating(Rating values);

	@PutMapping("/ratings/ratingId")
	public Rating updateRating(@PathVariable String ratingId, Rating rating);

}
