package com.xoriant.springboot.app.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.springboot.app.model.Product;
import com.xoriant.springboot.app.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductResource {
	
	@Autowired 
	ProductService productService;
	
	@GetMapping
	List<Product> view(){
		return productService.view();
	}
	
	@GetMapping("/category/{category}")
	List<Product> getByCategory(@PathVariable long category){
		return productService.getProductByCategory(category);
		
	}
	
	@PostMapping("/add")
	Product addProduct(@RequestBody Product product) {
		
		return productService.add(product);
	}
	
	@PutMapping("/update")
	Product updateProduct(@RequestBody Product product) {
		return productService.update(product);
	}
	
	@DeleteMapping("/{productId}")
	void deleteProduct(@PathVariable Long productId) {
		productService.delete(productId);
	}
	
	
}
