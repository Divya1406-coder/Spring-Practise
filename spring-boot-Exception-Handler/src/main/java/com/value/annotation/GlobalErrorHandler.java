package com.value.annotation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleException(IllegalArgumentException e) {
		
		
		return new ResponseEntity<Object>("Illegal Argue Exceoption handled by global", HttpStatus.BAD_REQUEST);
	}
}