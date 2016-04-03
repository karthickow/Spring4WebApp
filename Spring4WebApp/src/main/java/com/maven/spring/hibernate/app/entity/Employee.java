package com.maven.spring.hibernate.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	/*@TableGenerator(name="empId", table="EMP_PK_TABLE", pkColumnName="EMP_KEY", pkColumnValue="EMP_VALUE",
	allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="empId")*/
    @Column(name="ID")
	/*@SequenceGenerator(name="EMP_SEQ", sequenceName="EMP_SEQ", allocationSize=1)
	@GeneratedValue(generator="EMP_SEQ", strategy=GenerationType.SEQUENCE)*/
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
 
    @Column(name="FIRSTNAME")
    private String firstname;
 
    @Column(name="LASTNAME")
    private String lastname;
    
    @NotEmpty
    @Email
    @Column(name="EMAIL")
    private String email;
 
    @Column(name="TELEPHONE")   
    private String telephone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
    
    
}
