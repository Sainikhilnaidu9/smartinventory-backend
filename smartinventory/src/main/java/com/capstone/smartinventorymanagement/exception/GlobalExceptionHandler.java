package com.capstone.smartinventorymanagement.exception;

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
	
	@ExceptionHandler(InwardItemIdNotFoundException.class)
	public ResponseEntity<String> handlingException(InwardItemIdNotFoundException ee)
	{
		ResponseEntity<String> re=new ResponseEntity<>(ee.getMessage(),HttpStatus.NOT_FOUND);
		return re;
	}
	
	@ExceptionHandler(OutwardItemIdNotFoundException.class)
	public ResponseEntity<String> handlingException(OutwardItemIdNotFoundException ee)
	{
		ResponseEntity<String> re=new ResponseEntity<>(ee.getMessage(),HttpStatus.NOT_FOUND);
		return re;
	}
	@ExceptionHandler(EmployeeIdNotFoundException.class)
	public ResponseEntity<String> handlingException(EmployeeIdNotFoundException ee)
	{
		ResponseEntity<String> re=new ResponseEntity<>(ee.getMessage(),HttpStatus.NOT_FOUND);
		return re;
	}
	
	@ExceptionHandler(ReturnIdNotFoundException.class)
	public ResponseEntity<String> handlingException(ReturnIdNotFoundException ee)
	{
		ResponseEntity<String> re=new ResponseEntity<>(ee.getMessage(),HttpStatus.NOT_FOUND);
		return re;
	}
	
	@ExceptionHandler(ReportNotFoundException.class)
	public ResponseEntity<String> handlingException(ReportNotFoundException ee)
	{
		ResponseEntity<String> re=new ResponseEntity<>(ee.getMessage(),HttpStatus.NOT_FOUND);
		return re;
	}
	
	@ExceptionHandler(CartIdNotFoundException.class)
	public ResponseEntity<String> handlingException(CartIdNotFoundException ee)
	{
		ResponseEntity<String> re=new ResponseEntity<>(ee.getMessage(),HttpStatus.NOT_FOUND);
		return re;
	}
	@ExceptionHandler(UserEmailNotFoundException.class)
	public ResponseEntity<String> handlingException(UserEmailNotFoundException ee)
	{
		ResponseEntity<String> re=new ResponseEntity<>(ee.getMessage(),HttpStatus.NOT_FOUND);
		return re;
	}

}
