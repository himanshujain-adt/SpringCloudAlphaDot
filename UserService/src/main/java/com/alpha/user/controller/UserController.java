package com.alpha.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.user.entites.User;
import com.alpha.user.service.UserServiceInt;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceInt userServiceInt;

	int retryCount = 1;

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userServiceInt.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@GetMapping("/{userId}")
	// @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod =
	// "ratingHotelfallback")
	//@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelfallback")
	@RateLimiter(name="userRateLimiter" ,fallbackMethod = "ratingHotelfallback" )
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		//logger.info("Retry count:{}", retryCount);
		retryCount++;
		User user = userServiceInt.getUser(userId);
		return ResponseEntity.ok(user);

	}

	public ResponseEntity<User> ratingHotelfallback(String userId, Exception ex) {
		logger.info("Fallback is executed....service is down" + ex.getMessage());
		User user = User.builder().email("dummy@gmail.com").name("Dummy")
				.about("dummy user created because service is down").userId("9691969842EE").build();
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userServiceInt.getAllUser();
		return ResponseEntity.ok(allUser);
	}

}
