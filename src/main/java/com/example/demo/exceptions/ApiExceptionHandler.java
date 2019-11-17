package com.example.demo.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(value = { ApiRequestException.class })
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
		ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.BAD_REQUEST, ZonedDateTime.now());

		return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = { ApiInvalidRequestException.class })
	public ResponseEntity<Object> handleApiInvalidRequestException(ApiInvalidRequestException e) {
		ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.UNAUTHORIZED, ZonedDateTime.now());

		return new ResponseEntity<>(apiException, HttpStatus.UNAUTHORIZED);
	}
}
