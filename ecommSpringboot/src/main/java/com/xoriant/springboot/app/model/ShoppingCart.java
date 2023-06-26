package com.xoriant.springboot.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data


@Entity
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "c_id")
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int c_id;
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="id")
//	private User customerID;
	
//	 @OneToOne(mappedBy = "c_id")
//	    private User user;
	
//	@JsonBackReference
	
	private String userId;
	@JsonIgnore
	@OneToMany(mappedBy = "cart")
    Set<CartProduct> cartProduct;
	
	
	private double totalPrice;

	

	
}
