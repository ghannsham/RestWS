package com.spring.security.dto.testdb;

import com.spring.security.dto.AppDto;

public class UserPermissionGroupDto extends AppDto{

    private int userPermissionId;
    private String permission_group;
    private int userId;

	public UserPermissionGroupDto() {
	}

	public int getUserPermissionId() {
		return userPermissionId;
	}

	public void setUserPermissionId(int userPermissionId) {
		this.userPermissionId = userPermissionId;
	}

	public String getPermission_group() {
		return permission_group;
	}

	public void setPermission_group(String permission_group) {
		this.permission_group = permission_group;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
