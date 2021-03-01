package com.nagpassignment.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagpassignment.admin.model.BookServiceRequest;
import com.nagpassignment.admin.model.BookedService;
import com.nagpassignment.admin.model.ServiceProvider;
import com.nagpassignment.admin.service.AdminServiceImpl;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminServiceImpl;
	
//	@GetMapping("/bookservice")
//	String bookService(@RequestParam(value = "userId") String userId,
//			@RequestParam(value = "serviceId") String serviceId, @RequestParam(value = "pinCode") String pinCode) {
//		return adminServiceImpl.bookService(userId, serviceId, pinCode);
//	}
	
	@PostMapping("/bookservice")
	String bookService(@RequestBody BookServiceRequest bookServiceRequest) {
		return adminServiceImpl.bookService(bookServiceRequest);
	}
		
	@GetMapping("/getAllServices")
	List<Object> getServices() {		
		return adminServiceImpl.getAllSevices();
	}
	
	@GetMapping("/getBookedServices")
	List<BookedService> getBookedServices() {	
		return adminServiceImpl.getBookedServices();
	}
	
	
	
	
}
