package com.maven.spring.hibernate.app.service;

import java.util.List;

import com.maven.spring.hibernate.app.entity.Employee;

public interface EmployeeManager {
	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(Integer employeeId);
}
