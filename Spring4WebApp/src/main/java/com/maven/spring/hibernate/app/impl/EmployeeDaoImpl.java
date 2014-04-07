package com.maven.spring.hibernate.app.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maven.spring.hibernate.app.dao.EmployeeDAO;
import com.maven.spring.hibernate.app.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}
	
	@Override
	public void addEmployee(Employee employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		this.sessionFactory.getCurrentSession().merge(employee);
	}
	
	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee employee = (Employee)this.sessionFactory.getCurrentSession().load(Employee.class, employeeId);
		
		if(null!=employee){
			this.sessionFactory.getCurrentSession().delete(employee);
		}
		
	}

}
