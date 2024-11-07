package com.alpha.hotel.service;


import java.util.List;

import com.alpha.hotel.entites.Hotel;



public interface HotelService {

	Hotel create(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel getById(String hotelId);
}