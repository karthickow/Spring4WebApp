package com.maven.spring.hibernate.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maven.spring.hibernate.app.entity.Employee;
import com.maven.spring.hibernate.app.service.EmployeeManager;

@Controller
public class EmployeeController {
	
	private static final Logger logger = LogManager.getLogger(EmployeeController.class.getName());
	
	@Autowired
	private EmployeeManager employeeManager;
	
	@RequestMapping(value="/load", method=RequestMethod.GET)
	public String listEmployees(ModelMap modelMap){
		Employee employee = new Employee();
		modelMap.addAttribute("employee", employee);
		
		return "employee";
	}
	
	@RequestMapping(value="/allemployees", method=RequestMethod.GET)  
    @ResponseBody  
    public List<Employee> allEmployees() { 
		logger.info("Entering allEmployees method");
		
		List<Employee> employees = employeeManager.getAllEmployees();
		
		logger.info("All Employees Retrieved Successfully");
        
		return employees;  		
    }  
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
    public Employee addEmployee(@RequestBody Employee employee){
		logger.info("Employee {} is about to be added", employee.getFirstname());
		
		employeeManager.addEmployee(employee);
        
		logger.info("Employee {} added successfully", employee.getFirstname());
		
		return employee;
    }
 
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
    public Employee updateEmployee(@RequestBody Employee employee){
		
		logger.info("About to update Employee {}", employee.getFirstname());
		
    	employeeManager.updateEmployee(employee);
        
    	logger.info("Employee {} updated successfully", employee.getFirstname());
    	
    	return employee;
    }
	
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public  Employee deleteEmployee(@RequestBody Employee employee){
    	
    	logger.info("About to delete Employee {}", employee.getFirstname());
    	
    	employeeManager.deleteEmployee(employee.getId());
    	
    	logger.info("Employee {} deleted successfully", employee.getFirstname());
    	
    	return employee;
    }
 
    public void setEmployeeManager(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }
}
