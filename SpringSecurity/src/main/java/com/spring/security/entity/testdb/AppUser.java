package com.spring.security.entity.testdb;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import java.util.List;
/**
 * The persistent class for the app_user database table.
 * 
 */
@Entity
@Table(name="app_user")
@NamedQuery(name="AppUser.findAll", query="SELECT a FROM AppUser a")
public class AppUser extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String password;

	private String username;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<UserPermissionGroup> userPermissionGroups;

	public AppUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserPermissionGroup> getUserPermissionGroups() {
		return userPermissionGroups;
	}

	public void setUserPermissionGroups(List<UserPermissionGroup> userPermissionGroups) {
		this.userPermissionGroups = userPermissionGroups;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", userPermissionGroups=" + userPermissionGroups + "]";
	}

}