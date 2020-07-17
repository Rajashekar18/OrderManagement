package com.example.demo.service;

import com.example.demo.entity.OrderItem;

public interface OrderItemService {
	OrderItem createOrderItem(OrderItem orderItem);
	OrderItem getOrderItems(long productCode);

}
