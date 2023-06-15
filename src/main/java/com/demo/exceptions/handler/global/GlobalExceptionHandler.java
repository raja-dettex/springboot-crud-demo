package com.demo.exceptions.handler.global;

import org.hibernate.JDBCException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.exceptions.UserNotFoundException;
import com.demo.exceptions.response.ApiErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(UserNotFoundException.class)
	public ApiErrorResponse handleUserNotFoundException(UserNotFoundException ex) {
		logger.info("exception is {}", ex.getMessage());
		ApiErrorResponse response = new ApiErrorResponse(ex.getStatusCode(), ex.getMessage());
		return response;
	}
	
	@ExceptionHandler(JDBCException.class)
	public ApiErrorResponse handleJdbcException(JDBCException ex) {
		logger.info("the exception is {}", ex.getMessage());
		ApiErrorResponse response = new ApiErrorResponse(402, ex.getErrorMessage());
		return response;
	}
}
