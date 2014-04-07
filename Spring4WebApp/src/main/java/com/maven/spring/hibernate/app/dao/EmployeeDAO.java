package com.maven.spring.hibernate.app.dao;

import java.util.List;

import com.maven.spring.hibernate.app.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> getAllEmployees();
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
    public void deleteEmployee(Integer employeeId);
}
