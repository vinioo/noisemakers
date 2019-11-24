package com.noisemakers.exceptions;

public class ApiInvalidRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ApiInvalidRequestException(String message) {
		super(message);
	}
	
	public ApiInvalidRequestException(String message, Throwable cause) {
		super(message, cause);	
	}
}
