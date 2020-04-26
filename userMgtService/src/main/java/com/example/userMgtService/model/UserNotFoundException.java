package com.example.userMgtService.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="User Not Found")
public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -2581975292273282583L;

	
	String exception ;


	public String getException() {
		return exception;
	}


	public void setException(String exception) {
		this.exception = exception;
	}
	
	
}
