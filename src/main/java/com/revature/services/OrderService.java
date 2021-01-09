package com.revature.services;

import java.util.List;

import com.revature.models.Order;

public interface OrderService {

	public List<Order> findAllOrders();

	public Order findOrderById(int id);

	public Order saveOrder(Order order);

	public List<Order> findOrdersByPurchaserId(int id);
}
