package com.example.demo.serviceImpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.OrderItemRepository;
import com.example.demo.entity.OrderItem;
import com.example.demo.service.OrderItemService;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		
		return orderItemRepository.save(orderItem);
	}

	@Override
	public OrderItem getOrderItems(long productCode) {
		// TODO Auto-generated method stub
		Optional<OrderItem> orderItem = orderItemRepository.findById(productCode);
		
		if (orderItem.isPresent()) {
			return orderItem.get();
		} else {
			throw new ResourceNotFoundException("Resource not found with product code:"+productCode);
		}
	}

}
