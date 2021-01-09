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

import com.revature.models.Product;
import com.revature.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService ps;

	@Autowired
	public ProductController(ProductService ps) {
		this.ps = ps;
	}

	@GetMapping
	public ResponseEntity<List<Product>> findAllProducts() {

		return new ResponseEntity<List<Product>>(ps.findAllProducts(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable int id) {

		Product p = ps.findProductById(id);
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Product> saveNewProduct(@RequestBody Product product) {

		product.setProductId(0);
		ps.saveProduct(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED);

	}
}
