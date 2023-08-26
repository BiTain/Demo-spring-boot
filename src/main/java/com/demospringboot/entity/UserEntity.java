package com.demospringboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

	@Column(name = "username",columnDefinition ="nvarchar(255)")
	private String userName;
	
	@Column(name = "password",columnDefinition ="nvarchar(255)")
	private String passWord;
	
	@Column(name = "fullname",columnDefinition ="nvarchar(255)")
	private String fullName;
	
	@Column
	private Integer status;

	public String getUserName() {
		return userName;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"), 
	  inverseJoinColumns = @JoinColumn(name = "roleid"))
	private List<RoleEntity> roles = new ArrayList<>();

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
