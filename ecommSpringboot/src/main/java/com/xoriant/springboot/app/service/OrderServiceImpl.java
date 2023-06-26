package com.xoriant.springboot.app.service;

import java.util.Date;
import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.springboot.app.model.Orders;
import com.xoriant.springboot.app.model.Product;
import com.xoriant.springboot.app.model.ShoppingCart;
import com.xoriant.springboot.app.repository.CartProductRepository;
import com.xoriant.springboot.app.repository.OrderRepository;
import com.xoriant.springboot.app.repository.ProductRepository;
import com.xoriant.springboot.app.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	CartProductRepository cpRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@jakarta.transaction.Transactional
	@Override
	public Orders add(Long id) {
		ShoppingCart c=userRepository.getCartId(id);
		Date date=new Date();
		System.out.println(date);
		Orders order=new Orders();
		order.setC_id(c);
		order.setOrderDate(date);
		orderRepository.save(order);
//		Orders o;
//		System.out.println(order);
//		Orders o=
		if(orderRepository.getOrderId(order,productRepository.findById(id).get())!=null) {
			orderRepository.updateQuantity(productRepository.findById(id).get(), order);
		}else {
			orderRepository.addToOrderProduct(order.getOrder_Id(), id);
		}
		List<Product> p=cpRepository.getProductByCart(c);
		for(int i=0;i<p.size();i++) {
			cartService.removeProduct(p.get(i).getProductID());
		}
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
		return order;
	}
	
	
	
	
}
