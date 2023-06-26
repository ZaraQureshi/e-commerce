package com.xoriant.springboot.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xoriant.springboot.app.config.PasswordBean;
import com.xoriant.springboot.app.dto.RegisterDto;
import com.xoriant.springboot.app.exception.UserExistsException;
import com.xoriant.springboot.app.model.Role;
import com.xoriant.springboot.app.model.ShoppingCart;
import com.xoriant.springboot.app.model.User;
import com.xoriant.springboot.app.repository.UserRepository;

//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private PasswordBean passwordEncoder;

//	@Override
//	public User register(RegisterDto registerDto) {
//		ShoppingCart s=new ShoppingCart();
//		String encodedPassword = passwordEncoder.passwordEncoder().encode(registerDto.getPassword());
//		User user = new User(encodedPassword, registerDto.getEmail(), registerDto.getName(),s,
//				Arrays.asList(new Role(2, "ROLE_USER")));
//		if (emailExists(user.getEmail())) {
//			throw new UserExistsException();
//		}
		
//		return userRepository.save(user);
//
//	}
//
//	public boolean emailExists(String email) {
//		return userRepository.findByEmail(email) != null;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByEmail(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("Invalid username or password.");
//		}
//		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
//				getAuthorities(user.getRoles()));
//	}
//
//	private Collection<GrantedAuthority> getAuthorities(Collection<Role> roles) {
//		Collection<GrantedAuthority> authorities = new ArrayList<>();
//		for (Role role : roles) {
//			authorities.add(new SimpleGrantedAuthority(role.getName()));
//		}
//		return authorities;
//	}
//
//}
