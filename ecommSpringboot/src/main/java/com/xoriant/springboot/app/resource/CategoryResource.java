package com.xoriant.springboot.app.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.springboot.app.model.Category;
import com.xoriant.springboot.app.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryResource {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	List<Category> getCategory(){
		return categoryService.getCategory();
	}
}
