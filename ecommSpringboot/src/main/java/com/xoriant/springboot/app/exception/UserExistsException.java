package com.xoriant.springboot.app.exception;

public class UserExistsException extends RuntimeException {
	public UserExistsException() {
		super("User Already exists");
	}
}
