package com.alpha.hotel.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.hotel.entites.Hotel;
import com.alpha.hotel.service.HotelService;


@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/save")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		String responseId=UUID.randomUUID().toString();
		hotel.setHotelId(responseId);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	@GetMapping("/getById/{hotelId}")
	public ResponseEntity<Hotel> getById(@PathVariable String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getById(hotelId));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Hotel>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
	}
}