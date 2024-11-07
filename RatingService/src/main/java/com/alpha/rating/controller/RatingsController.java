package com.alpha.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.rating.entites.Ratings;
import com.alpha.rating.service.RatingsService;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

	@Autowired
	RatingsService ratingsService;

	@PostMapping("/save")
	public ResponseEntity<Ratings> create(@RequestBody Ratings ratings) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingsService.create(ratings));
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Ratings>> getAllRatings() {
		return ResponseEntity.ok(ratingsService.getAllRatings());
	}

	@GetMapping("/getByUserId/{userId}")
	public ResponseEntity<List<Ratings>> getRatingsByUserId(@PathVariable String userId) {
		return ResponseEntity.ok(ratingsService.getRatingsByUserId(userId));
	}

	@GetMapping("/getByHotelId/{hotelId}")
	public ResponseEntity<List<Ratings>> getRatingsByHotelId(@PathVariable String hotelId) {
		System.out.println(hotelId);
		return ResponseEntity.ok(ratingsService.getRatingsByHotelId(hotelId));
	}

}