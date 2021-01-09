package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

}
