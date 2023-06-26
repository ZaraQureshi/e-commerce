package com.xoriant.springboot.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsPasswordService;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import com.xoriant.springboot.app.service.UserService;

//@Configuration
//@EnableWebSecurity
//public class MySecurityConfiguration{
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private PasswordBean password;
//	
//	public void configure(HttpSecurity http) throws Exception{
//		http
//			.cors().and()
//			.csrf().disable()
//			.authorizeRequests()
//			.anyRequest().permitAll();
//			.authorizeRequests()
//			.antMatchers("/customer/**").hasRole("USER")
//			.antMatchers("/public/**").hasRole("USER")
//			.antMatchers("/product/**").hasRole("USER")
//			.anyRequest()
//			.authenticated()
//			.and()
//	          .formLogin().loginPage("/login")
//	          .loginProcessingUrl("/perform_login")
//	          .defaultSuccessUrl("/homepage",true)
//	          .failureUrl("/error.html")
//			.and()
//			.httpBasic();
//	}
	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception{
////		auth.inMemoryAuthentication().withUser("zara").password(this.passwordEncoder().encode("1234")).roles("NORMAL");
////		auth.inMemoryAuthentication().withUser("admin").password(this.passwordEncoder().encode("admin")).roles("ADMIN");
//		auth.authenticationProvider(authenticationProvider());
//	}
//	
	
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
//		auth.setUserDetailsService(userService);
//		auth.setPasswordEncoder(password.passwordEncoder());
//		return auth;
//	}
	
	
	
//}
