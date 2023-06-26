package com.xoriant.springboot.app.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException() {
		super("User does not exist");
	}
}
