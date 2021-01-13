package com.spring.security.validator;

import java.util.List;

import com.spring.security.dto.AppDto;
import com.spring.security.dto.ValidationErrorDto;

public interface IAppValidator {

	public List<ValidationErrorDto> validate(AppDto dto);
}
