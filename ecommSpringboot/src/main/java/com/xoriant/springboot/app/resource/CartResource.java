package com.xoriant.springboot.app.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.springboot.app.model.Product;
import com.xoriant.springboot.app.model.ShoppingCart;
import com.xoriant.springboot.app.service.CartService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/cart")

public class CartResource {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/addUser/{id}")
	ShoppingCart addUser(@PathVariable String id) {
		return cartService.addUser(id);
	}
	
	@PostMapping("/add/{id}/{prodid}/{price}")
	ShoppingCart addToCart(@PathVariable long id,@PathVariable long prodid,@PathVariable double price) {
		return cartService.add(id, prodid,price);
	}
	
	@GetMapping("/getByCartId/{cartId}")
	ShoppingCart getByCartId(@PathVariable int cartId) {
		return cartService.getByCartId(cartId);
	}
	
	
	
	@GetMapping
	List<ShoppingCart> getCart(){
		return cartService.getCart();
	}
	
	@GetMapping("/get/{id}")
	List<Product> getProductByCart(@PathVariable long id){
		return cartService.getProductByCart(id);
	}
	
	@GetMapping("/remove/{id}")
	Product removeProduct(@PathVariable Long id) {
		return cartService.removeProduct(id);
	}
}

