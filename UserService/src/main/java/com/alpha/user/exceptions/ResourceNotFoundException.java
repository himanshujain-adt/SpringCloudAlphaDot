package com.alpha.user.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Resource Not Found On Server");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
