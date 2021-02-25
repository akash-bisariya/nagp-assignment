package com.nagpassignment.userservice.controller;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 13ba1127e9d00619baa88fdc9ff3af71db8a1071
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagpassignment.userservice.model.User;
import com.nagpassignment.userservice.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userservice;
<<<<<<< HEAD
=======
	
>>>>>>> 13ba1127e9d00619baa88fdc9ff3af71db8a1071

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/adduser")
	User addUser(@RequestParam(value = "name") String name,
			@RequestParam(value = "email", defaultValue = "test@test.com") String email) {
		return userservice.addUser(name, email);
	}

	@GetMapping("/getallusers")
	Map<String, User> getAllUsers() {
<<<<<<< HEAD
		return userservice.getAllUsers();
=======
		return userservice.getAllUsers();	

>>>>>>> 13ba1127e9d00619baa88fdc9ff3af71db8a1071
	}

}
