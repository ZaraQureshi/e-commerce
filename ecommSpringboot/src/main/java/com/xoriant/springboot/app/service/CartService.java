package com.xoriant.springboot.app.service;

import java.util.List;

import com.xoriant.springboot.app.model.Product;
import com.xoriant.springboot.app.model.ShoppingCart;

public interface CartService {

	ShoppingCart add(long id, long prodid,double price);

	List<ShoppingCart> getCart();

	List<Product> getProductByCart(long id);

	Product removeProduct(Long id);
	ShoppingCart addUser(String id);

	ShoppingCart getByCartId(int cartId);


}
