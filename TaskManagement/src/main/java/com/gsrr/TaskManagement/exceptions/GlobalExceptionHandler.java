package com.gsrr.TaskManagement.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({ 
		IdNotFoundException.class,
		TaskNotFoundException.class, 
        UserNotFoundException.class,
        ProjectNotFoundException.class 
        })
	public ResponseEntity<String> handleNotFound(RuntimeException ex) {
		return ResponseEntity.status(404).body(ex.getMessage());
	}
}
