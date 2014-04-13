package com.maven.spring.hibernate.app.service;

import java.util.List;

import com.maven.spring.hibernate.app.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Integer employeeId);
}
