package com.xoriant.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xoriant.springboot.app.model.Orders;
import com.xoriant.springboot.app.model.Product;
import com.xoriant.springboot.app.model.ShoppingCart;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	@Query("select product from OrderProduct c where c.order=:id and c.product=:p")
	Product getOrderId(@Param(value="id") Orders id,@Param(value="p") Product p);
	
	@Modifying
	@Query(value = "insert into order_product(order_id,product_id,quantity) VALUES (:order_id,:prodid,1)", nativeQuery = true)
	int addToOrderProduct(@Param(value="order_id")int o_id,@Param(value="prodid") long prodid);

	@Modifying
	@Query("update OrderProduct c set c.quantity=c.quantity+1 where c.product=:id and c.order=:orderid")
	int updateQuantity(@Param(value="id") Product prodid,@Param(value="orderid") Orders orderid);

//	boolean getOrderByOrder_Id(int order_Id);
	
	
}
