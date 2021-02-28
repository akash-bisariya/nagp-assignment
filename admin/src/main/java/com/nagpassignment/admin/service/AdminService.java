package com.nagpassignment.admin.service;

import java.util.List;

import com.nagpassignment.admin.model.BookedService;

public interface AdminService {
	
	String bookService(String userId,String serviceId,String pinCode);
	
	List<Object> getAllSevices();

	List<BookedService> getBookedServices();
	
}
