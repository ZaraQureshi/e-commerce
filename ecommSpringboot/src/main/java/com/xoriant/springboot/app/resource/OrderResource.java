package com.xoriant.springboot.app.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.springboot.app.model.Orders;
import com.xoriant.springboot.app.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins="*")
public class OrderResource {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/add/{id}")
	Orders addOrder(@PathVariable Long id) {
		return orderService.add(id);
	}
}
