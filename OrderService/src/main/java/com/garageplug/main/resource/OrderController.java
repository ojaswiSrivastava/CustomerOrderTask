package com.garageplug.main.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garageplug.main.model.Order;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/order")
	public ResponseEntity<String> order(@RequestBody @Valid Order order, @RequestParam(value = "email") String email ) {
		
		return orderService.add(order, email);	
	}	

}
