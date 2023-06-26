package com.xoriant.springboot.app.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//import jakarta.annotation.Resource;

public class Test {
	public static void main(String[] args) {
		try {
			Resource resource = new ClassPathResource("C:\\Users\\qureshi_z\\Documents\\db.logs");
			File file = resource.getFile();
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			System.out.println(bufferedReader);
			}catch(Exception e) {
				System.out.println(e);
			}

	}
	
//	String[] array = bufferedReader.lines().collect(Collectors.joining()).split(",");
//	System.out.println(Arrays.asList(array));
}
