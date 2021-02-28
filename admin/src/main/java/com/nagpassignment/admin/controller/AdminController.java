package com.nagpassignment.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagpassignment.admin.model.ServiceProvider;
import com.nagpassignment.admin.service.AdminServiceImpl;

@RestController
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminServiceImpl;
	
	@GetMapping("/bookservice")
	List<ServiceProvider> bookService(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "serviceId") String serviceId, @RequestParam(value = "pinCode") String pinCode) {
		return adminServiceImpl.bookService(userId, serviceId, pinCode);
	}
		
	@GetMapping("/getAllServices")
	List<Object> getServices() {	
		return adminServiceImpl.getAllSevices();
	}
	
	
}
