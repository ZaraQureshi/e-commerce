package com.xoriant.springboot.app.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_Id;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_id")
    private ShoppingCart c_id;
	private Date orderDate;

	@JsonIgnore
	@OneToMany(mappedBy = "order")
    Set<OrderProduct> orderProduct;
}
