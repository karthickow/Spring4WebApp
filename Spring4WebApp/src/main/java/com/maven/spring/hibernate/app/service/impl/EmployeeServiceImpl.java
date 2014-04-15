package com.maven.spring.hibernate.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maven.spring.hibernate.app.dao.EmployeeDAO;
import com.maven.spring.hibernate.app.entity.Employee;
import com.maven.spring.hibernate.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> getAllEmployees(){
		return employeeDAO.getAllEmployees();
	}
	
	@Override
	@Transactional
	public void addEmployee(Employee employee){
		employeeDAO.addEmployee(employee);
	}
	
	@Override
	@Transactional
	public void updateEmployee(Employee employee){
		employeeDAO.updateEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId){
		employeeDAO.deleteEmployee(employeeId);
	}
}
