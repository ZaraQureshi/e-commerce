package com.xoriant.springboot.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long categoryID;	
	private String categoryName;
//	private long totalItems;
}
