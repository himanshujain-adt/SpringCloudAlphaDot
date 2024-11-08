package com.alpha.rating.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.rating.entites.Ratings;

public interface RatingRepository extends JpaRepository<Ratings, String> {

	List<Ratings> findByUserId(String userId);

	List<Ratings> findByHotelId(String hotelId);
}