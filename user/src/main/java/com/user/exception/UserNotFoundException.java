package com.user.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String message) {
		super(message);
	}
	
	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = 1L;
}
