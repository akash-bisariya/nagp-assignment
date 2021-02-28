package com.nagpassignment.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.nagpassignment.userservice.model.User;

@Service
public class UserServiceImpl implements UserService {

	private List<User> users = new ArrayList<User>();
	private final AtomicLong counter = new AtomicLong(100);

	@Override
	public User addUser(String name, String emailId) {
		User user = new User(counter.incrementAndGet(), name, emailId);
		this.users.add(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		if (this.users.isEmpty()) {
			this.users.add(new User(counter.incrementAndGet(), "Akash", "test1@gmail.com"));
			this.users.add(new User(counter.incrementAndGet(), "Ankit", "test2@gmail.com"));
			this.users.add(new User(counter.incrementAndGet(), "Nitya", "test3@gmail.com"));
			this.users.add(new User(counter.incrementAndGet(), "Shivam", "test4@gmail.com"));
		}
		return this.users;
	}

}
