package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Order;

public interface OrderDAO extends JpaRepository<Order, Integer> {

	public List<Order> findByPurchaserCustomerId(int id);
}
