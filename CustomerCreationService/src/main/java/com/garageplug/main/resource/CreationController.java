package com.garageplug.main.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.garageplug.main.model.Customer;


@RestController
public class CreationController {
	
	@Autowired
	private CustomerService customerService; 
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/create")
	public ResponseEntity<String> create(@RequestBody @Valid Customer customer ) {
		
		return customerService.create(customer);	
	}	


}
