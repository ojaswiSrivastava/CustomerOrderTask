package com.garageplug.main.resource;

import org.springframework.http.ResponseEntity;

import com.garageplug.main.model.Order;

public interface OrderService {
	
	public ResponseEntity<String> add(Order order, String email);

}
