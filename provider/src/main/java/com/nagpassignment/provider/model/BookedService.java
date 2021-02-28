package com.nagpassignment.provider.model;

public class BookedService {
	private String serviceId;
	private Long bookingId;
	//1.Booked 2.ProviderAssigned 3. Completed
	private String bookingStatus;
	private String providerId;
	
	public BookedService(String serviceId,Long bookingId, String bookingStatus,String providerId) {
		super();
		this.serviceId = serviceId;
		this.bookingId = bookingId;
		this.bookingStatus = bookingStatus;
		this.providerId = providerId;
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

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

}
