package com.nagpassignment.userservice.service;

import java.util.List;
import java.util.Map;

import com.nagpassignment.userservice.model.User;

public interface UserService {

	User addUser(String name, String emailId);

	List<User> getAllUsers();

}
