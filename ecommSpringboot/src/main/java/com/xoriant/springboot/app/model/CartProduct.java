package com.xoriant.springboot.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id")
public class CartProduct {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long id;

//		@JsonManagedReference
	    @ManyToOne
	    @JoinColumn(name = "cart_id")
	    ShoppingCart cart;

//		@JsonManagedReference
	    @ManyToOne
	    @JoinColumn(name = "product_id")
	    Product product;

	    int quantity;
	    
	    // standard constructors, getters, and setters
	
}
