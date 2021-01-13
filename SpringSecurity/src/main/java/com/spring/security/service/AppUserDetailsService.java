package com.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.dto.ValidationErrorDto;
import com.spring.security.dto.testdb.AppUserDto;
import com.spring.security.entity.testdb.AppUser;
import com.spring.security.entity.testdb.UserPermissionGroup;
import com.spring.security.mapper.AppMapper;
import com.spring.security.repository.AppUserRepository;
import com.spring.security.validator.AppUserValidator;
import com.sun.el.stream.Optional;

@Service
public class AppUserDetailsService {

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private AppUserValidator userValidator;
	
	public AppUserDto getAppUserByUserName(String userName)
	{
		return AppMapper.APP_USER_MAPPER.entityToDto(
				appUserRepository.findByusername(userName).orElse(null));
	}
	
	public List getAppUsers()
	{
		List<AppUser> users = appUserRepository.findAll();
		users.forEach(System.out::println);
		return AppMapper.APP_USER_MAPPER.entityToDto(users);
	}
	
	public Object saveAppUser(AppUserDto dto)
	{
		List<ValidationErrorDto> errors = userValidator.validate(dto);
		if(errors.isEmpty())
		{
			AppUser user = AppMapper.APP_USER_MAPPER.dtoToEntity(dto);
			user.setAuditFields();
			user.getUserPermissionGroups().stream().forEach(ug->{
			ug.setAuditFields();
			ug.setUser(user);
			});
			System.out.println("Saving user " + user.toString());
			return AppMapper.APP_USER_MAPPER.entityToDto(appUserRepository.save(user));
		}
		else {
				return errors;
			}
	}
}
