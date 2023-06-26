package com.xoriant.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xoriant.springboot.app.model.ShoppingCart;
import com.xoriant.springboot.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String UserEmail);
	@Query("select c_id from User where id=:id")
	ShoppingCart getCartId(@Param(value="id") long id);
}
