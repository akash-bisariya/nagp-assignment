package com.nagpassignment.userservice.service;

import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.nagpassignment.userservice.model.User;

@Service
public class UserServiceImpl implements UserService {

	private Map<String, User> users = new ConcurrentHashMap<String, User>();
	private final AtomicLong counter = new AtomicLong(100);

	@Override
	public User addUser(String name, String emailId) {
		User user = new User(counter.incrementAndGet(), name, emailId);
		this.users.put(user.getUserId().toString(), user);
		return user;
	}

	@Override
	public Map<String, User> getAllUsers() {
		return this.users;
	}

}
