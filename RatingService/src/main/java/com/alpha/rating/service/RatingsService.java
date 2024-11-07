package com.alpha.rating.service;



import java.util.List;

import com.alpha.rating.entites.Ratings;

public interface RatingsService {

	
	Ratings create(Ratings ratings);
	
	List<Ratings> getAllRatings();
	
	List<Ratings> getRatingsByUserId(String userId);
	
	List<Ratings> getRatingsByHotelId(String hotelId);
}