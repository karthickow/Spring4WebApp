package com.sprsec.controller;

import java.security.Principal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maven.spring.hibernate.app.controller.EmployeeController;

@Controller
public class SecurityController {
	
	private static final Logger logger = LogManager.getLogger(EmployeeController.class.getName());
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String goToLoginPage(ModelMap model) {
		logger.info("In goToLoginPage() method. Login page loaded.");
		return "access/login-form";
	}
	
	@RequestMapping(value="/login-form", method=RequestMethod.GET)
	public String getLoginPage(ModelMap model) {
		logger.info("In getLoginPage() method. Login page loaded.");
		return "access/login-form";
	}
	
	@RequestMapping(value = "/failure", method=RequestMethod.GET)
 	public String getLoginFailurePage(ModelMap model, Principal principal) {
		String msg = "Login Failure";
		if(principal!=null)
			logger.error("In getLoginFailurePage() method. "+msg+" for user {}.", principal.getName());
		else
			logger.error("In getLoginFailurePage() method. "+msg);
		model.addAttribute("msg", msg);
		model.addAttribute("error", true);
		return "access/login-form";
	}
	
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
 	public String getLogoutSuccessPage(Principal principal) {
		String msg = "Logout Success!";
		if(principal!=null)
			logger.info("In getLogoutSuccessPage() method. "+msg+" for user {}.", principal.getName());
		else
			logger.info("In getLogoutSuccessPage() method. "+msg);
		return "access/login-form?msg="+msg;
	}
	
	@RequestMapping(value="/expired-session", method=RequestMethod.GET)
	public String getExpiredSessionPage(ModelMap model, Principal principal) {
		String sessionExpiredMsg = "Your Session Expired. Please login again.";
		if(principal!=null)
			logger.info("In getExpiredSessionPage() method. "+sessionExpiredMsg+" For user {}.", principal.getName());
		else
			logger.info("In getExpiredSessionPage() method. "+sessionExpiredMsg);
		model.addAttribute("error", true);
		return "expired-session";
	}

	@RequestMapping(value="/invalid-session", method=RequestMethod.GET)
	public String getDuplicateSessionPage(ModelMap model, Principal principal) {
		String sessionExpiredMsg = "Duplicate Session Page.";
		if(principal!=null)
			logger.warn("In getDuplicateSessionPage() method. "+sessionExpiredMsg+" for user {}.", principal.getName());
		else
			logger.warn("In getDuplicateSessionPage() method. "+sessionExpiredMsg);
		model.addAttribute("error", true);
		return "invalid-session";
	}
	
	@RequestMapping(value = "/denied", method=RequestMethod.GET)
 	public String getDeniedPage(ModelMap model) {
		String deniedMsg= "Unauthorized. Access denied!";
		logger.warn("In getDeniedPage() method. "+deniedMsg);
		model.addAttribute("error", true);
		return "access/denied";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHomePage(Principal principal) {
		String loginSuccess = "Login Success.";
		if(principal!=null)
			logger.info("In getHomePage() method. "+loginSuccess+" for user {}.", principal.getName());
		else
			logger.info("In getHomePage() method. "+loginSuccess);
		return "home";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String getUserPage(Principal principal) {
		if(principal!=null)
			logger.info("In getUserPage() method. User {} page is loaded.", principal.getName());
		else
			logger.info("In getUserPage() method. User page is loaded.");
		return "user";
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String getAdminPage(ModelMap modelMap, Principal principal) {
		if(principal!=null)
			logger.info("In getAdminPage() method. Admin {} page is loaded.", principal.getName());
		else
			logger.info("In getAdminPage() method. Admin page is loaded.");
		return "admin";
	}
	
	@RequestMapping(value="/employee", method=RequestMethod.GET)
	public String getEmployeePage(ModelMap modelMap, Principal principal) {
		if(principal!=null)
			logger.info("In getEmployeePage() method. Employee page is redirected to employee controller for user {}.", principal.getName());
		else
			logger.info("In getEmployeePage() method. Employee page is redirected to employee controller");
		return "redirect:/employee/loadEmployee";
	}
}
