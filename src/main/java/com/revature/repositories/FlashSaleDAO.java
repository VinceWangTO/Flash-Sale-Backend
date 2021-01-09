package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.FlashSale;

public interface FlashSaleDAO extends JpaRepository<FlashSale, Integer> {

}
