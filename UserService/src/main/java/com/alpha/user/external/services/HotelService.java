package com.alpha.user.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alpha.user.entites.Hotel;

@FeignClient(name="HOTEL-MIRCO-SERVICE")
public interface HotelService {
	@GetMapping("/hotels/getById/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);

}
