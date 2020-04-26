package com.example.RegService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RegService.model.Customer;
import com.example.RegService.service.RegService;


@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RegController {

	@Autowired
	RegService regService;
	
	
	@PostMapping("/reg")
	public Customer  saveCustomer(@RequestBody Customer customer) {
	        return regService.save(customer);
	    }
	
}
