package com.nagpassignment.provider.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.nagpassignment.provider.model.BookedService;
import com.nagpassignment.provider.model.ServiceProvider;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {
	@Autowired
	private JmsTemplate jmsTemplate;

	List<ServiceProvider> serviceProviders = new ArrayList<ServiceProvider>();
	private final AtomicLong counter = new AtomicLong(1000);

	@Override
	public ServiceProvider addServiceProvider(ServiceProvider serviceProvider) {
		ServiceProvider provider = new ServiceProvider(counter.incrementAndGet(), serviceProvider.getName(), serviceProvider.getServicePinCode(), serviceProvider.getMobile(),
				serviceProvider.getServiceCharges(),serviceProvider.getServices());
		this.serviceProviders.add(provider);
		return provider;
	}

	@Override
	public List<ServiceProvider> getAllServiceProvider() {
		if (this.serviceProviders.isEmpty()) {
			this.serviceProviders.add(new ServiceProvider(counter.incrementAndGet(), "Akash","110044","7651991216","100",new String[]{"2001","2002","2003"}));
			this.serviceProviders.add(new ServiceProvider(counter.incrementAndGet(), "Amit","242001","8750025141","200",new String[]{"2001","2002","2003"}));
			this.serviceProviders.add(new ServiceProvider(counter.incrementAndGet(), "Ankit","242001", "8745763412","150",new String[]{"2001","2002","2003"}));
			this.serviceProviders.add(new ServiceProvider(counter.incrementAndGet(), "Jagdish","110044","6754614614","100",new String[]{"2004","2005","2006"}));
			this.serviceProviders.add(new ServiceProvider(counter.incrementAndGet(), "Vinod","243001", "8743514314","250",new String[]{"2001","2005","2006"}));
			this.serviceProviders.add(new ServiceProvider(counter.incrementAndGet(), "Faizaa","243001", "9876461451","100",new String[]{"2004","2006","2003"}));
		}
		return this.serviceProviders;
	}

	@Override
	public List<ServiceProvider> getProviderByPinCode(String pincode) {
		List<ServiceProvider> listOfProviders = new ArrayList<ServiceProvider>();
		for (ServiceProvider i : this.serviceProviders) {
			if (i.getServicePinCode().equals(pincode))
				listOfProviders.add(i);
		}
		return listOfProviders;
	}
	 
	
	@JmsListener(destination="ServiceBookedEventForProvider")
	public void ServiceBookedForProvider(Map<String, String> bookedService) {
		System.out.println("Getting jms template"+bookedService.get("serviceId"));
		
		//For acceptance of service by provider
		jmsTemplate.convertAndSend("ServiceAccept",bookedService); 
		
		//For rejection of service by provider -
		//jmsTemplate.convertAndSend("ServiceDeny",bookedService);
		

		
	}

}
