package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired	
 	private OrderRepository orderRepository;

	@Override
	public Order createOrder(Order order) {
		
		return orderRepository.save(order);
	}

	@Override
	public Order getOrder(String name) {
		// TODO Auto-generated method stub
		Optional<Order> order = orderRepository.findByCustomerName(name);
		if (order.isPresent()) {
			return order.get();
		} else {
			throw new ResourceNotFoundException("Resource not found with Customer Name"+name);
		}
	}
  
}
