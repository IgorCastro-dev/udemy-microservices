package com.igor.employeeservice.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErroDetails> handlerResourceNotFoundException
	(ResourceNotFoundException exception,WebRequest webRequest){
		
		ErroDetails erroDetails = ErroDetails.builder()
											.timesTamp(LocalDateTime.now())
											.message(exception.getMessage())
											.path(webRequest.getDescription(false))
											.codeName("EMPLOYEE_NOT_FOUND")
											.build();
		return new ResponseEntity<>(erroDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErroDetails> handlerException
	(Exception exception,WebRequest webRequest){
		ErroDetails erroDetails = ErroDetails.builder()
											.timesTamp(LocalDateTime.now())
											.message(exception.getMessage())
											.path(webRequest.getDescription(false))
											.codeName("INTERNAL_SERVER_ERROR")
											.build();
		return new ResponseEntity<>(erroDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
