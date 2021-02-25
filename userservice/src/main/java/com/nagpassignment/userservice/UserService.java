package com.nagpassignment.userservice;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.User;

@RestController
public class UserService {
	private final AtomicLong counter = new AtomicLong(100);

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	@GetMapping("/adduser")
	User addUser(@RequestParam(value = "name") String name,@RequestParam(value = "email",defaultValue="test@test.com") String email) {
		return new User(counter.incrementAndGet(),name,email);
	}
	
	@GetMapping("/getallusers")	
	List<User>	getAllUsers(){
		return null;	
		
	}
	
	
	
}
