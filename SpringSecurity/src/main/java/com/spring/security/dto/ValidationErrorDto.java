package com.spring.security.dto;

public class ValidationErrorDto {

	private String errorCode;
	private String errorMessage;
	
	public ValidationErrorDto() {
	}

	public ValidationErrorDto(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
