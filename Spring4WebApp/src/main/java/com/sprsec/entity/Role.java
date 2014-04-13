package com.sprsec.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class Role {
	
	@Id
	@SequenceGenerator(name="ROLES_SEQ", sequenceName="ROLES_SEQ")
	@GeneratedValue(generator="ROLES_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	private String role;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USERS_ROLES", 
		joinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName="ID")},
		inverseJoinColumns = {@JoinColumn(name="USER_ID", referencedColumnName="USERID")}
	)
	private Set<User> userRoles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<User> userRoles) {
		this.userRoles = userRoles;
	}
	
}
