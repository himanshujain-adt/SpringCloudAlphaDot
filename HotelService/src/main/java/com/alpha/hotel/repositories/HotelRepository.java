package com.alpha.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.hotel.entites.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}