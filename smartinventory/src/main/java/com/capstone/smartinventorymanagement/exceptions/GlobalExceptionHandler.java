package com.capstone.smartinventorymanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ItemIdNotFoundException.class)
	public ResponseEntity<String> handlingException(ItemIdNotFoundException ee)
	{
		ResponseEntity<String> re=new ResponseEntity<>(ee.getMessage(),HttpStatus.NOT_FOUND);
		return re;
	}
	
	@ExceptionHandler(GodownIdNotFoundException.class)
	public ResponseEntity<String> handlingException(GodownIdNotFoundException ee)
	{
		ResponseEntity<String> re=new ResponseEntity<>(ee.getMessage(),HttpStatus.NOT_FOUND);
		return re;
	}

}
