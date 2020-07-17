package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@RestController
public class OrderResource {
	@Autowired
	private OrderService orderService;

	@PostMapping(path = "/order", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		return ResponseEntity.ok().body(this.orderService.createOrder(order));
	}

	@GetMapping(path = "/order/{name}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Order> getOrder(@PathVariable String name) {
		return ResponseEntity.ok().body(this.orderService.getOrder(name));
	}
}
