package com.spring.security.entity.testdb;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;


/**
 * The persistent class for the app_user database table.
 * 
 */
@Entity
@Table(name="user_permission_group")
@NamedQuery(name="UserPermissionGroup.findAll", query="SELECT a FROM UserPermissionGroup a")
public class UserPermissionGroup extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userPermissionId;

	private String permission_group;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id" )
	private AppUser user;

	public UserPermissionGroup() {
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

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "UserPermissionGroup [userPermissionId=" + userPermissionId + ", permission_group=" + permission_group
				+ "]";
	}

}