package com.garageplug.main.resource;

import org.springframework.http.ResponseEntity;

import com.garageplug.main.model.Customer;


public interface CustomerService {
	
	public ResponseEntity<String> create(Customer customer);


}
