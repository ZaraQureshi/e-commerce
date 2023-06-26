package com.xoriant.springboot.app.model;
import com.xoriant.springboot.app.model.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	private String password;
	private String email;
	private String name;	
	private double contactNumber;	
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_id")
    private ShoppingCart c_id;
	
	@ManyToMany()
	@JoinTable(name = "user_roles")
	@JoinColumn(name="user_id")
	private Collection<Role> roles;
	
	
	
	public User(int userID, String userPassword, String userEmail, String userName,
			double contactNumber, String address, Collection<Role> roles) {
		super();
		this.id = userID;
		this.password = userPassword;
		this.email = userEmail;
		this.name = userName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.roles = roles;
	}
	
	public User(String password, String email, String name,ShoppingCart c, List<Role> roles) {
		this.password = password;
		this.email = email;
		this.name = name;	
		this.c_id=c;
		this.roles = roles;
	}

	public User() {
		
	}

	
	
	
	
}
