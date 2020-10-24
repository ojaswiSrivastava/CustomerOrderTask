package com.garageplug.main.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garageplug.main.model.Customer;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	Customer findByEmail(String email);


}
