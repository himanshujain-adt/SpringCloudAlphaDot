package com.alpha.user.controller;

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

import com.alpha.user.entites.Rating;
import com.alpha.user.entites.User;
import com.alpha.user.external.services.RatingService;
import com.alpha.user.service.UserServiceInt;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceInt userServiceInt;
	
	

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userServiceInt.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		User user = userServiceInt.getUser(userId);
		return ResponseEntity.ok(user);

	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser=userServiceInt.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	

}
