package com.revature.services;

import java.util.List;

import com.revature.models.Product;

public interface ProductService {

	public List<Product> findAllProducts();

	public Product findProductById(int id);

	public Product saveProduct(Product product);
}
