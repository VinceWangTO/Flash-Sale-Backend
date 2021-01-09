package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Order;
import com.revature.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private OrderService os;

	@Autowired
	public OrderController(OrderService os) {
		this.os = os;
	}

	@GetMapping
	public ResponseEntity<List<Order>> findAllOrders() {

		return new ResponseEntity<List<Order>>(os.findAllOrders(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> findOrderById(@PathVariable int id) {

		Order o = os.findOrderById(id);
		System.out.println(o == null);
		if (o == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(o, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Order> saveNewProduct(@RequestBody Order order) {

		order.setOrderId(0);
		os.saveOrder(order);
		return new ResponseEntity<>(order, HttpStatus.CREATED);

	}

	@GetMapping("/purchaser/{id}")
	public ResponseEntity<List<Order>> findAllByPurchaserId(@PathVariable int id) {

		return new ResponseEntity<List<Order>>(os.findOrdersByPurchaserId(id), HttpStatus.OK);
	}
}
