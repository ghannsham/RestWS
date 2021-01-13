package com.spring.security.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.spring.security.common.ErrorConstants;
import com.spring.security.dto.AppDto;
import com.spring.security.dto.ValidationErrorDto;
import com.spring.security.dto.testdb.AppUserDto;
import com.spring.security.repository.AppUserRepository;

import static com.spring.security.common.CommonUtil.isNullOrEmpty;
@Component
//@Scope(value = "prototype")
@RequestScope
public class AppUserValidator extends AbstractValidator {

	@Autowired
	private AppUserRepository userRepo;
	
	public AppUserValidator() {
		
	}

	@Override
	public List<ValidationErrorDto> validate(AppDto dto) {
		AppUserDto userDto = (AppUserDto) dto;
		validateUser(userDto);
		return validationErrors;
	}

	private void validateUser(AppUserDto dto)
	{
		if(isNullOrEmpty(dto.getUsername(), dto.getFirstName(), dto.getLastName(), dto.getPassword()))
		{
			addValidationError(ErrorConstants.REQUIRED_FIELDS_MISSING, 
					"userName/firstName/lastName/password");
		}
		
		userRepo.findByusername(dto.getUsername()).ifPresent(user ->
				this.addValidationError(ErrorConstants.DUPLICATE_USER, user.getUsername()
				));
		
		if(dto.getUserPermissionGroups() == null || dto.getUserPermissionGroups().isEmpty())
		{
			this.addValidationError(ErrorConstants.USER_ROLE_MISSING, dto.getUsername());
		}
	}

}
