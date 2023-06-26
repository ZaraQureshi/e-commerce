package com.xoriant.springboot.app;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication
public class SpringPoc1Application {

	public static void main(String[] args) {
		try {
		SpringApplication.run(SpringPoc1Application.class, args);
		
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
