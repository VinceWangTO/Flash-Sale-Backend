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

import com.revature.models.FlashSale;
import com.revature.services.FlashSaleService;

@RestController
@RequestMapping("/api/flashsales")
public class FlashSaleController {

	private FlashSaleService fs;

	@Autowired
	public FlashSaleController(FlashSaleService fs) {
		this.fs = fs;
	}

	@GetMapping
	public ResponseEntity<List<FlashSale>> findAllFlashSales() {

		return new ResponseEntity<List<FlashSale>>(fs.findAllFlashSales(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<FlashSale> findFlashSaleById(@PathVariable int id) {

		FlashSale f = fs.findFlashSaleById(id);
		if (f == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(f, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<FlashSale> saveNewFlashSale(@RequestBody FlashSale flashSale) {

		flashSale.setFlashSaleId(0);
		fs.saveFlashSale(flashSale);
		return new ResponseEntity<>(flashSale, HttpStatus.CREATED);

	}
}
