package com.spring.security.dto.testdb;

import java.util.List;

import com.spring.security.dto.AppDto;

public class AppUserDto extends AppDto{

    private int userId;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private List<UserPermissionGroupDto> userPermissionGroups;

	public AppUserDto() 
	{
		
	}

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserPermissionGroupDto> getUserPermissionGroups() {
		return userPermissionGroups;
	}

	public void setUserPermissionGroups(List<UserPermissionGroupDto> userPermissionGroups) {
		this.userPermissionGroups = userPermissionGroups;
	}
}
