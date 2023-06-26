package com.xoriant.springboot.app.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "productID")
public class Product {
	@Id
	private long productID;	
	private String productName;	
	private double productPrice;	
	private int productQuantity;	
	private String productBrand;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="categoryid")
	private Category category;
	
	@JsonIgnore
//	@JsonBackReference
	@OneToMany(mappedBy = "product")
    Set<CartProduct> cartProduct;

	@JsonIgnore
	@OneToMany(mappedBy = "product")
    Set<OrderProduct> orderProduct;

}
