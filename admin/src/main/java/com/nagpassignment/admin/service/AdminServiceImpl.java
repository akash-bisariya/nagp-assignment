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
	public String bookService(String userId, String serviceId, String pinCode) {
		String url = "provider/getprovider/" + pinCode;
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("provider", false);
		ResponseEntity<ServiceProvider[]> provider = restTemplate.getForEntity(instance.getHomePageUrl()+ url, ServiceProvider[].class);
		List<ServiceProvider> providerList = (Arrays.asList(provider.getBody()));
		List<ServiceProvider> servingProviderList= new ArrayList<ServiceProvider>();
		for (ServiceProvider i : providerList) {
			String[] list = i.getServices();
			for(String str : list) {
				if(str.equals(serviceId)) {
					servingProviderList.add(i);
				}	
			}
				
		}
		System.out.print("You are in getallservices"+servingProviderList.size());
		if(servingProviderList.isEmpty()) {
			return "No Service Provider Available Currently On Your Location.";
		}
		else {
			BookedService bookedservice = new BookedService(serviceId,bookingId.incrementAndGet(),"Booked","");
			bookedServices.add(bookedservice);
			Map<String, Object> map = new HashMap<>(); 
	        map.put("serviceId", bookedservice.getBookingId());
	        map.put("providerId", bookedservice.getProviderId()); 
			jmsTemplate.convertAndSend("ServiceBookedEventForProvider",bookedservice.getServiceId());
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
	public void ServiceBookedForProvider(BookedService bookedService) {
//		jmsTemplate.convertAndSend("ServiceAccept",bookedService.getProviderId()); 
		this.bookedServices.get(0).setBookingStatus("Confirmed");
	}

	@Override
	public List<BookedService> getBookedServices() {
		return this.bookedServices;
	}


}
