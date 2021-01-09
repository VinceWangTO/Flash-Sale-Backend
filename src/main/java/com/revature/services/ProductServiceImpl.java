package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Product;
import com.revature.repositories.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDAO po;

	@Autowired
	public ProductServiceImpl(ProductDAO po) {
		this.po = po;
	}

	@Override
	public List<Product> findAllProducts() {
		return po.findAll();
	}

	@Override
	public Product findProductById(int id) {
		return po.getOne(id);
	}

	@Override
	public Product saveProduct(Product product) {
		return po.saveAndFlush(product);
	}

}
