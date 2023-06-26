package com.xoriant.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xoriant.springboot.app.model.Product;
import com.xoriant.springboot.app.model.ShoppingCart;
import com.xoriant.springboot.app.model.User;
@Repository
public interface CartRepository extends JpaRepository<ShoppingCart, Integer>{

	
	@Query("select totalPrice from ShoppingCart where c_id=:id")
	Double getTotalPriceByCid(int id);
	
	@Modifying
	@Query(value="update ShoppingCart s set s.totalPrice=:price where s.c_id=:c_id")
	int addPriceToCart(@Param(value="price") double price,@Param(value="c_id") int c_id);
	
	@Modifying
	@Query("delete from CartProduct where product=:id")
	int removeProduct(Product id);
	
}
