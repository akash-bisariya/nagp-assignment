package com.nagpassignment.admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagpassignment.admin.model.BookServiceRequest;
import com.nagpassignment.admin.model.BookedService;
import com.nagpassignment.admin.model.ServiceProvider;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class AdminServiceImpl implements AdminService {
	private final AtomicLong bookingId = new AtomicLong(10000);
	List<BookedService> bookedServices = new ArrayList<BookedService>();

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private EurekaClient eurekaClient;


	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	@Override
	public String bookService(BookServiceRequest bookServiceRequest) {
		String url = "provider/getprovider/" + bookServiceRequest.getPinCode();
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("provider", false);
		ResponseEntity<ServiceProvider[]> provider = restTemplate.getForEntity(instance.getHomePageUrl()+ url, ServiceProvider[].class);
		List<ServiceProvider> providerList = (Arrays.asList(provider.getBody()));
		List<ServiceProvider> servingProviderList= new ArrayList<ServiceProvider>();
		for (ServiceProvider i : providerList) {
			String[] list = i.getServices();
			for(String str : list) {
				if(str.equals(bookServiceRequest.getServiceId())) {
					servingProviderList.add(i);
				}	
			}
				
		}
		System.out.print("You are in getallservices"+servingProviderList.size());
		if(servingProviderList.isEmpty()) {
			return "No Service Provider Available Currently On Your Location.";
		}
		else {
			//Selecting first Service Provider from list
			//Can be customized so that it can select the other if first provider reject the service
			BookedService bookedservice = new BookedService(bookServiceRequest.getServiceId(),bookingId.incrementAndGet(),"Booked",servingProviderList.get(0),bookServiceRequest.getUserId());
			bookedServices.add(bookedservice);
			Map<String, String> map = new HashMap<>(); 
	        map.put("serviceId", bookedservice.getBookingId().toString());
	        map.put("providerId", bookedservice.getProviderDetails().getProviderId().toString()); 
			jmsTemplate.convertAndSend("ServiceBookedEventForProvider",map);
			return "Your Service Has Been Booked Successfully. We Will Share the Service Provider Details Shortly.";
		}
		
//		return servingProviderList;	
	}

	@Override
	public List<Object> getAllSevices() {
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("services", false);
		Object[] list = restTemplate.getForObject(instance.getHomePageUrl()+"services/getallservices", Object[].class);
		List<Object> serviceList = Arrays.asList(list);
		System.out.print("You are in getallservices");
		return serviceList;
	}
	

	@JmsListener(destination="ServiceAccept")
	public void ServiceBookedForProvider(Map<String, String> bookedService) {
		System.out.println("Confirmed service accept");
		/**
		 * Status changes to Accepted when provider accept the service
		 * Notify User or Change the Booked Sevice Status to Accepted
		 */
		this.bookedServices.get(0).setBookingStatus("Provider-Accepted");
//		this.bookedServices.get(0).setProviderId(bookedService.get("providerId"));
	}
	
	
	@JmsListener(destination="ServiceDeny")
	public void ServiceNotBookedForProvider(Map<String, String> bookedService) {
		System.out.println("Confirmed service accept");
		/**
		 * Status changes to Denied when provider denied the service
		 */
		this.bookedServices.get(0).setBookingStatus("Provider-Denied");
	}

	@Override
	public List<BookedService> getBookedServices() {
		return this.bookedServices;
	}


}
