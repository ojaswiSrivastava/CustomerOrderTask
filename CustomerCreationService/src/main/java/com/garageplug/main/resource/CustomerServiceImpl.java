package com.garageplug.main.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.garageplug.main.Category;
import com.garageplug.main.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ResponseEntity<String> create(Customer customer) {

		Customer customerExists = customerRepository.findByEmail(customer.getEmail());
		
		if (customerExists != null) {
			return new ResponseEntity<>("Customer already exists", HttpStatus.BAD_REQUEST); 
		}
		
		else {
			customer.setCategory(Category.REGULAR);
			
			customerRepository.save(customer);
			return new ResponseEntity<>("Customer created", HttpStatus.CREATED);   
		}
	}

}
