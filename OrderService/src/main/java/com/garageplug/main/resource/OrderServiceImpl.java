package com.garageplug.main.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.garageplug.main.Category;
import com.garageplug.main.CategoryUtil;
import com.garageplug.main.model.Customer;
import com.garageplug.main.model.Discount;
import com.garageplug.main.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ResponseEntity<String> add(Order order, String email) {
		
		Customer customer = customerRepository.findByEmail(email);
		
		if(!(customer.getCategory() == Category.REGULAR)) {
			
			Discount discount = new Discount();
			discount.setOrder(order);
			discount.setCustomer(customer);
			discount.setAmount(CategoryUtil.calculateDiscount(customer.getCategory(), order.getAmount()));
			
			order.setDiscount(discount);
		}
		
		order.setCustomer(customer);
		
		List<Order> orders = customer.getOrders();
		orders.add(order);
		
		Category category= CategoryUtil.updateCatergoryIfAppicable(orders);
		customer.setCategory(category); 
		
		customer.setOrders(orders);
		
		customerRepository.save(customer);
						
		return new ResponseEntity<>("Order Successful", HttpStatus.OK);   
		
	}

}
