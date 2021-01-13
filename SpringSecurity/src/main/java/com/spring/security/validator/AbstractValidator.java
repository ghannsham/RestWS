package com.spring.security.validator;

import java.util.ArrayList;
import java.util.List;

import com.spring.security.common.ErrorConstants;
import com.spring.security.dto.ValidationErrorDto;

public abstract class AbstractValidator implements IAppValidator 
{
	protected List<ValidationErrorDto> validationErrors = new ArrayList<>();
	
	protected void clearValidationErrors() 
	{
		this.validationErrors.clear();
	}
	
	protected void addValidationError(ValidationErrorDto errorDto)
	{
		this.validationErrors.add(errorDto);
	}
	
	protected void addValidationError(String errorCode, Object... values)
	{
		String errorDesc = ErrorConstants.getErrorDescription(errorCode, values);
		this.validationErrors.add(new ValidationErrorDto(errorCode, errorDesc));
	}
	
	public AbstractValidator() {
	}
}
