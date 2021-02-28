package com.nagpassignment.services.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagpassignment.services.model.ServiceModel;
import com.nagpassignment.services.service.ServiceInterfaceImpl;

@RestController
@RequestMapping(value = "/services")
public class ServicesController {

	@Autowired
	ServiceInterfaceImpl serviceInterfaceImpl;

	@GetMapping("/addservice")
	ServiceModel addProvider(@RequestParam(value = "serviceName") String serviceName,
			@RequestParam(value = "serviceDescription") String serviceDescription) {
		return serviceInterfaceImpl.addServices(serviceName, serviceDescription);
	}

	@GetMapping("/getallservices")
	List<ServiceModel> getAllProviders() {
		return serviceInterfaceImpl.getAllServices();

	}

}
