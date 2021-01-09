package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Order;
import com.revature.repositories.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderDAO od;

	@Autowired
	public OrderServiceImpl(OrderDAO od) {
		super();
		this.od = od;
	}

	@Override
	public List<Order> findAllOrders() {
		// TODO Auto-generated method stub
		return od.findAll();
	}

	@Override
	public Order findOrderById(int id) {
		// TODO Auto-generated method stub
		return od.getOne(id);
	}

	@Override
	public Order saveOrder(Order order) {
		// TODO Auto-generated method stub
		return od.saveAndFlush(order);
	}

	@Override
	public List<Order> findOrdersByPurchaserId(int id) {
		// TODO Auto-generated method stub
		return od.findByPurchaserCustomerId(id);
	}

}
