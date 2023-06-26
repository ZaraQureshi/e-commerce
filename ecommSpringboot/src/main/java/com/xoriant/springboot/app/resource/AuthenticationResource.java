package com.xoriant.springboot.app.resource;

//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/public")
//@EnableWebSecurity

public class AuthenticationResource {
//	@PostMapping("/login")
//	public String login() {
//		return ("<h1>Login</h1>");
//	}
	
	@GetMapping
	public String home() {
		return ("<h1>New home</h1>");
	}
	
	@GetMapping("/login")
	public String authenticate() {
		return "authenticated";
		
	}
}
