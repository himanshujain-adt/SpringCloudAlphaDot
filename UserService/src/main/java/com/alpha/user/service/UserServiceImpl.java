package com.alpha.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.alpha.user.entites.Hotel;
import com.alpha.user.entites.Rating;
import com.alpha.user.entites.User;
import com.alpha.user.exceptions.ResourceNotFoundException;
import com.alpha.user.external.services.HotelService;
import com.alpha.user.external.services.RatingService;
import com.alpha.user.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInt {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;

	
	// private Logger logger = (Logger)
	// LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on server !!!:" + userId));
		Rating[] ratingOfUser = restTemplate
				.getForObject("http://RATING-MIRCO-SERVICE/ratings/getByUserId/" + user.getUserId(), Rating[].class);
		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		ArrayList<Rating> ratingList = (ArrayList<Rating>) ratings.stream().map(rating -> {
			// return rating.getHotelId();
			
			//ResponseEntity<Hotel> forEntity = restTemplate
			//		.getForEntity("http://HOTEL-MIRCO-SERVICE/hotels/getById/" + rating.getHotelId(), Hotel.class);
			//Hotel hotel = forEntity.getBody();
			Hotel hotel=hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		return user;
	}
	
	

}
