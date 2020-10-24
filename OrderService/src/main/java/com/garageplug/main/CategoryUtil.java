package com.garageplug.main;

import java.util.List;

import com.garageplug.main.model.Order;

public class CategoryUtil {
	
	private static float rate;
	
	public static float calculateDiscount(Category category, float amount) {
		
		if(category == Category.GOLD) {
			rate = 10;
			float discount = (rate/100) * amount;
			return discount;
		}
		
		else if(category == Category.PLATINUM) {
			rate = 20;
			float discount = (rate/100) * amount;
			return discount;
		}
		
		return 0;
		
	}
	
	public static Category updateCatergoryIfAppicable(List<Order> orders) {
		
		if(orders.size()>=10 && orders.size()<20) {
			return Category.GOLD;
		}
		
		else if(orders.size()>=20) {
			return Category.PLATINUM;
		}
		
		return Category.REGULAR;
		
	}

}
