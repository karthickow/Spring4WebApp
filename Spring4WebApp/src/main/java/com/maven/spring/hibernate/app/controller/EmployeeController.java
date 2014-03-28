package com.maven.spring.hibernate.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maven.spring.hibernate.app.entity.Employee;
import com.maven.spring.hibernate.app.service.EmployeeManager;

@Controller
public class EmployeeController {
	
	private static final Logger logger = LogManager.getLogger(EmployeeController.class.getName());
	
	@Autowired
	private EmployeeManager employeeManager;
	
	@RequestMapping(value="/load", method=RequestMethod.GET)
	public String listEmployees(ModelMap modelMap){
		logger.info("Entering listEmployees method");
		
		modelMap.addAttribute("employee", new Employee());
		modelMap.addAttribute("employeeList", employeeManager.getAllEmployees());
		
		logger.info("Employees Retrieved Successfully");
		
		return "editEmployeeList";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute(value="employee") Employee employee, BindingResult result){
		logger.info("Employee {} is about to be added", employee.getFirstname());
		
		employeeManager.addEmployee(employee);
        
		logger.info("Employee {} added successfully", employee.getFirstname());
		
		return "redirect:/load";
    }
 
    @RequestMapping("/delete/{employeeId}")
    public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId){
    	
    	employeeManager.deleteEmployee(employeeId);
        
    	return "redirect:/load";
    }
 
    public void setEmployeeManager(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }
}
