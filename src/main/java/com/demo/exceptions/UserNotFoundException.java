package com.demo.exceptions;

import org.slf4j.LoggerFactory;

public class UserNotFoundException extends NullPointerException {

	private String message;
	private int statusCode;
	private static final long serialVersionUID = 1L;
	public UserNotFoundException(String message , int status) {
		
		super(message);
		this.message = message;
		this.statusCode = status;
	}
	public String getMessage() {
		return message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	

}
