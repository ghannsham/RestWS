package com.spring.security.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.spring.security.dto.ValidationErrorDto;

public class BaseController {

	public BaseController() {
		// TODO Auto-generated constructor stub
	}

	protected HttpStatus getHttpStatus(Object obj)
	{
		HttpStatus status = HttpStatus.OK;
		if(obj instanceof List) {
			if(!((List)obj).isEmpty() && (((List)obj).get(0) instanceof ValidationErrorDto))
			{
				status = HttpStatus.BAD_REQUEST;
			}	
		}
		return status;
	}
}
