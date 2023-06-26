package com.xoriant.springboot.app.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.springboot.app.dto.RegisterDto;
import com.xoriant.springboot.app.exception.UserExistsException;
import com.xoriant.springboot.app.model.User;
//import com.xoriant.springboot.app.service.UserService;
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RestController
//@RequestMapping("/customer")
//public class UserResource {
//
//	@Autowired
//	private UserService userService;
//	
//	@GetMapping("/home")
//	public String home() {
//		return("<h1>Home</h1>");
//	}
//	
//	@PostMapping("/register")
//	public User register(@RequestBody RegisterDto registerDto)  {
//		return userService.register(registerDto);
//	}
//}
