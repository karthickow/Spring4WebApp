package com.maven.spring.hibernate.app.dao;

import java.util.List;

import com.maven.spring.hibernate.app.entity.Employee;

public interface EmployeeDAO {
	public void addEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
}
