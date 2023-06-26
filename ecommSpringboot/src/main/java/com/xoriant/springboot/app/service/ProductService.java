package com.xoriant.springboot.app.service;

import java.util.List;

import com.xoriant.springboot.app.model.Product;

public interface ProductService {

	Product add(Product product);
	
	List<Product> getProduct();
	
	Product update(Product product);

	void delete(Long productId);

	List<Product> view();


	List<Product> getProductByCategory(long category);

}
