package com.xoriant.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xoriant.springboot.app.model.CartProduct;
import com.xoriant.springboot.app.model.Product;
import com.xoriant.springboot.app.model.ShoppingCart;

public interface CartProductRepository extends JpaRepository<CartProduct,Long>{

	@Modifying
	@Query(value = "insert into cart_product(cart_id,product_id,quantity) VALUES (:c_id,:prodid,1)", nativeQuery = true)
	int addToCartProduct(@Param(value="c_id")int c_id,@Param(value="prodid") long prodid);

	@Query("select product from CartProduct c where c.cart=:id and c.product=:p")
	Product getCartId(@Param(value="id") ShoppingCart id,@Param(value="p") Product p);
	
	@Modifying
	@Query("update CartProduct c set c.quantity=c.quantity+1 where c.product=:id and c.cart=:cartid")
	int updateQuantity(@Param(value="id") Product prodid,@Param(value="cartid") ShoppingCart cartid);
	
	@Query("select quantity from CartProduct c where c.cart=:cart and c.product=:prod")
	int getQuantityByCart(ShoppingCart cart,Product prod);
	
	@Query("select count(cart) from CartProduct c where c.cart=:cart")
	int getCountOfCart(ShoppingCart cart);
	
	@Query("select product from CartProduct p where p.cart=:cart")
	List<Product> getProductByCart(ShoppingCart cart);
//	List<Product> getProductByCart(ShoppingCart cart);
	
}
