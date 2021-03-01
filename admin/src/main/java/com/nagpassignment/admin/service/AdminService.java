package com.nagpassignment.admin.service;

import java.util.List;

import com.nagpassignment.admin.model.BookServiceRequest;
import com.nagpassignment.admin.model.BookedService;

public interface AdminService {
	
	String bookService(BookServiceRequest bookServiceRequest);
	
	List<Object> getAllSevices();

	List<BookedService> getBookedServices();
	
}
