package com.xoriant.springboot.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class OrderProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

//	@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "order_id")
    Orders order;

//	@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    int quantity;
}
