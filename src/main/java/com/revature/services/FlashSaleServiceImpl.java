package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.FlashSale;
import com.revature.repositories.FlashSaleDAO;

@Service
public class FlashSaleServiceImpl implements FlashSaleService {

	private FlashSaleDAO fd;

	@Autowired
	public FlashSaleServiceImpl(FlashSaleDAO fd) {
		super();
		this.fd = fd;
	}

	@Override
	public List<FlashSale> findAllFlashSales() {

		return fd.findAll();
	}

	@Override
	public FlashSale findFlashSaleById(int id) {

		return fd.getOne(id);
	}

	@Override
	public FlashSale saveFlashSale(FlashSale flashSale) {

		return fd.saveAndFlush(flashSale);
	}

}
