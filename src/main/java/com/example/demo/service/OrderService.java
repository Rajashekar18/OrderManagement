package com.example.demo.service;

import com.example.demo.entity.Order;

public interface OrderService {
	
	Order createOrder(Order order);
	Order getOrder(String customerName);

}
