package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.dto.SpringSecurityResponse;
import com.spring.security.dto.testdb.AppUserDto;
import com.spring.security.entity.testdb.AppUser;
import com.spring.security.service.AppUserDetailsService;
import com.spring.security.common.CommonUtil;
@RestController
@RequestMapping("/api")
public class EmployeeController extends BaseController{

	@Autowired
	private AppUserDetailsService userDetailsService;
	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getEmployees()
	{
		return new ResponseEntity<>("Hello World", HttpStatus.OK);
	}
	
	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getUsers()
	{
		List<AppUserDto> users = userDetailsService.getAppUsers(); 
		SpringSecurityResponse response = new SpringSecurityResponse(HttpStatus.OK, users);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getUser(String userName)
	{
		AppUserDto appUser = userDetailsService.getAppUserByUserName(userName);
		SpringSecurityResponse response = new SpringSecurityResponse(HttpStatus.OK, appUser);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/users/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUser( @RequestBody AppUserDto userDto)
	{
		Object appUser = userDetailsService.saveAppUser(userDto);
		System.out.println("Saving user " + CommonUtil.toJson(userDto));
		HttpStatus status = getHttpStatus(appUser);
		SpringSecurityResponse response = new SpringSecurityResponse(status, appUser);
		return new ResponseEntity<>(response, status);
	}
}
