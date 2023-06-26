package com.xoriant.springboot.app.service;

import java.util.List;
import java.util.UUID;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.xoriant.springboot.app.model.CartProduct;
import com.xoriant.springboot.app.model.Product;
import com.xoriant.springboot.app.model.ShoppingCart;
import com.xoriant.springboot.app.repository.CartProductRepository;
import com.xoriant.springboot.app.repository.CartRepository;
import com.xoriant.springboot.app.repository.ProductRepository;
import com.xoriant.springboot.app.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CartProductRepository cpRepository;
	
	@Autowired
	RestTemplate restTemplate;
//	
	@Override
	public ShoppingCart addUser(String id) {
		ShoppingCart c=new ShoppingCart();
//		c.setC_id();
		c.setUserId(id);
		cartRepository.save(c);
		return c;
	}
	
	@Transactional
	@Override 
	public ShoppingCart add(long id,long prodid,double price) {
		System.out.println("#############################");
		
		ShoppingCart c=userRepository.getCartId(id);
//		System.out.println(c);
		Integer cid=c.getC_id();
//		System.out.println(cid);
		if(cpRepository.getCartId(c,productRepository.findById(prodid).get()) != null) {
			cpRepository.updateQuantity(productRepository.findById(prodid).get(),c);
		}
		else {
			cpRepository.addToCartProduct(cid, prodid);
		}
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
//		System.out.println(cpRepository.getQuantityByCart(c));
//		double total=0;
//		int totalQuantity=0;
//		for(int i=0;i<cpRepository.getCountOfCart(c);i++) {
//			totalQuantity+=cpRepository.getQuantityByCart(c, productRepository.findById(prodid).get());
//			total+=totalQuantity*productRepository.getProductPriceByProductID(prodid);
//		}
		cartRepository.addPriceToCart(cartRepository.getTotalPriceByCid(cid)+price, cid);
		return c;
	}
//		ShoppingCart c=cartRepository.save(cart);
		
//		
		
//		try {
//			System.out.println("****---************************************************************************");
//			System.out.println(userRepository.getCartId(1).getClass());
//			System.out.println("****----************************************************************************");
//			System.out.println(userRepository.getCartId(1) == null);
//			if(userRepository.getCartId(1)==null) {
//				
//				cartRepository.addCartToUser(cart, 1);
//				System.out.println("here");
//			}
//			else if((ShoppingCart) cartRepository.getCartId(1)==null){
//				System.out.println("present");
//			}
//		}
//		catch (Exception e) {
//			System.out.println(e);
//		}
//		System.out.println(cart.getC_id()+" "+cart.getTotalPrice());
		
	
	@Override
	public List<ShoppingCart> getCart() {
		return cartRepository.findAll();
	}

	@Override
	public List<Product> getProductByCart(long id) {
		ShoppingCart c=userRepository.getCartId(id);
		
//		Integer cid=c.getC_id();
//		System.out.println(c);
//		System.out.println(cpRepository.getProductByCart(c));
		
		return cpRepository.getProductByCart(c);
	}
	
	@Transactional
	@Override
	public Product removeProduct(Long id) {
		Product p=productRepository.findById(id).get();
		cartRepository.removeProduct(p);
		return p;
	}

	@Override
	public ShoppingCart getByCartId(int cartId) {
		return cartRepository.findById(cartId).get();
	}

	

}
