package com.xoriant.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xoriant.springboot.app.model.Product;
import com.xoriant.springboot.app.model.ShoppingCart;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> getByCategoryCategoryID(long category);
	
	Double getProductPriceByProductID(long id); 
	
	
	
//	@Modifying
//	@Query("update Product p set p.cartId=:cartid where p.productID=:prodid")
//	int addToCart(@Param(value="cartid") long cartid,@Param(value="prodid")long prodid);
//	
//	@Query("select cartId from Product where productID=:prodid")
//	int checkcart(@Param(value="prodid") long prodid);
	
}
