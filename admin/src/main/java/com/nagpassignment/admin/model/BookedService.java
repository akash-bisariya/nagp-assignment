package com.nagpassignment.admin.model;

public class BookedService {
	private String serviceId;
	private Long bookingId;
	private String userId;
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	//1.Booked 2.Provider-Accepted 3. Provider-Denied 4. Completed
	private String bookingStatus;
	private ServiceProvider providerDetails;
	
	
	public ServiceProvider getProviderDetails() {
		return providerDetails;
	}

	public void setProviderDetails(ServiceProvider providerDetails) {
		this.providerDetails = providerDetails;
	}

	public BookedService(String serviceId,Long bookingId, String bookingStatus, ServiceProvider providerDetails,String userId) {
		super();
		this.serviceId = serviceId;
		this.bookingId = bookingId;
		this.bookingStatus = bookingStatus;
		this.providerDetails = providerDetails;
		this.userId=userId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

}
