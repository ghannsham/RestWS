package com.spring.security.dto;

import org.springframework.http.HttpStatus;

public class SpringSecurityResponse {

	private HttpStatus status;
	private Object data;
	private String message;
	
	public SpringSecurityResponse(HttpStatus status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	public SpringSecurityResponse(HttpStatus status, Object data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}
	
	public SpringSecurityResponse() {
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
