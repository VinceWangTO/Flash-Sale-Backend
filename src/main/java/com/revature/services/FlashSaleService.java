package com.revature.services;

import java.util.List;

import com.revature.models.FlashSale;

public interface FlashSaleService {

	public List<FlashSale> findAllFlashSales();

	public FlashSale findFlashSaleById(int id);

	public FlashSale saveFlashSale(FlashSale flashSale);
}
