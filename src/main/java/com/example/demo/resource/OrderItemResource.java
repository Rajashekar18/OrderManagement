package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OrderItem;
import com.example.demo.service.OrderItemService;

@RestController
public class OrderItemResource {

	@Autowired
	private OrderItemService orderItemService;

	@PostMapping(path = "/orderItem", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
		return ResponseEntity.ok().body(this.orderItemService.createOrderItem(orderItem));
	}

	@GetMapping(path = "/orderItem/{productCode}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<OrderItem> getOrder(@PathVariable long productCode) {
		return ResponseEntity.ok().body(this.orderItemService.getOrderItems(productCode));
	}

}
