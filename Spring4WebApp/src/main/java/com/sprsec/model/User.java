package com.sprsec.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@Column(name="USERID")
	@SequenceGenerator(name="USERS_SEQ", sequenceName="USERS_SEQ")
	@GeneratedValue(generator="USERS_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@NotBlank
	@Column(name="USERNAME")
	private String userName;	
	
	@NotBlank
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ISACTIVE")
	private int isActive;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="USERS_ROLES",
		joinColumns = {@JoinColumn(name="USER_ID", referencedColumnName="USERID")},
		inverseJoinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName="ID")}
	)
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}	

}
