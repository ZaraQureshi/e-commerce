package com.xoriant.springboot.app.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.xoriant.springboot.app.model.Product;
import com.xoriant.springboot.app.repository.CategoryRepository;
import com.xoriant.springboot.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	@Override
	public Product add(Product product) {
		
//		categoryRepository.addToTotalItems(product.getCategory());
		return productRepository.save(product);
	}
	@Override
	public List<Product> getProduct() {
		
		return productRepository.findAll();
	}
	
	@Override
	public Product update(Product product) {
		
		return productRepository.save(product);
	}
	@Override
	public void delete(Long productId) {
		
		productRepository.deleteById(productId);
	}
	@Override
	public List<Product> view() {
		testlogs();
		return productRepository.findAll();
	}
	@Override
	public List<Product> getProductByCategory(long category) {
		
		return productRepository.getByCategoryCategoryID(category);
	}
	
	public void testlogs() {
		try {
			String folder="Documents\\Resume";
			String filename="db.logs";
//			Resource resource = new ClassPathResource("C:\\Users\\qureshi_z\\Documents\\db.logs");
//			System.out.println(new ClassPathResource("C:\\Users\\qureshi_z\\Documents\\db.logs").getFile().getAbsolutePath());
//			File file = resource.getFile();
			BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\qureshi_z\\"+folder+"\\"+filename));
			String line = null;
			List<String> lines = new LinkedList<String>();
	        while ((line = bufferedReader.readLine()) != null) {
	           lines.add(line);
	        }
			System.out.println(lines);
			}catch(Exception e) {
				System.out.println(e);
			}
	}

}
