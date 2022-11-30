package com.user.exception;

public class UserBadRequestException extends RuntimeException{
	public UserBadRequestException(String message) {
		super(message);
	}

	public UserBadRequestException(String message, Throwable cause) {
		super(message, cause);
	}
	private static final long serialVersionUID = 1L;

}
