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
import com.maven.spring.hibernate.app.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private static final Logger logger = LogManager.getLogger(EmployeeController.class.getName());
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/employee/loadEmployee", method=RequestMethod.GET)
	public String listEmployees(ModelMap modelMap){
		logger.info("Employee page is loading...");
		Employee employee = new Employee();
		modelMap.addAttribute("employee", employee);
		logger.info("Employee page loaded.");
		return "employee";
	}
	
	@RequestMapping(value="/employee/allemployees", method=RequestMethod.GET)  
    @ResponseBody  
    public List<Employee> allEmployees() { 
		logger.info("Retrieving all employees...");
		List<Employee> employees = employeeService.getAllEmployees();
		logger.info("All Employees Retrieved Successfully.");
		return employees;  		
    }  
	
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	@ResponseBody
    public Employee addEmployee(@RequestBody Employee employee){
		logger.info("Employee {} is about to be added", employee.getFirstname());
		employeeService.addEmployee(employee);
		logger.info("Employee {} added successfully.", employee.getFirstname());
		return employee;
    }
 
	@RequestMapping(value = "/employee/update", method = RequestMethod.POST)
	@ResponseBody
    public Employee updateEmployee(@RequestBody Employee employee){
		logger.info("Employee {} is about to be updated.", employee.getFirstname());
		employeeService.updateEmployee(employee);
    	logger.info("Employee {} updated successfully.", employee.getFirstname());
    	return employee;
    }
	
    @RequestMapping(value = "/employee/delete", method = RequestMethod.POST)
    @ResponseBody
    public Employee deleteEmployee(@RequestBody Employee employee){
    	logger.info("Employee {} is about to be deleted.", employee.getFirstname());
    	employeeService.deleteEmployee(employee.getId());
    	logger.info("Employee {} deleted successfully.", employee.getFirstname());
    	return employee;
    }
}
