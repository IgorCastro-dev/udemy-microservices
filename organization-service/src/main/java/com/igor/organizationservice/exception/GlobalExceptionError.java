package com.igor.organizationservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionError {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErroDetail> resourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
		ErroDetail erroDetail = ErroDetail.builder()
										.timesTamp(LocalDateTime.now())
										.message(exception.getMessage())
										.path(webRequest.getDescription(false))
										.erroCode("ORGANIZATION_NOT_FOUND")
										.build();
		return new ResponseEntity<>(erroDetail,HttpStatus.NOT_FOUND);
	}
}
