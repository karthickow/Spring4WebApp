package com.sprsec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityNavigation {
	
	@RequestMapping(value="/expired-session", method=RequestMethod.GET)
	public ModelAndView invalidSession() {
		ModelAndView modelAndView = new ModelAndView("expired-session");
		modelAndView.addObject("error", true);
		return modelAndView;
	}

	@RequestMapping(value="/invalid-session", method=RequestMethod.GET)
	public ModelAndView duplicateSession() {
		ModelAndView modelAndView = new ModelAndView("invalid-session");
		modelAndView.addObject("error", true);
		return modelAndView;
	}
	
	@RequestMapping(value="/login-form", method=RequestMethod.GET)
	public String login(Model model, @RequestParam(required=false) String message) {
		model.addAttribute("message", message);
		return "access/login-form";
	}
	
	@RequestMapping(value = "/denied", method=RequestMethod.GET)
 	public String denied() {
		return "access/denied";
	}
	
	@RequestMapping(value = "/login/failure", method=RequestMethod.GET)
 	public String loginFailure() {
		String message = "Login Failure!";
		return "redirect:/login-form?message="+message;
	}
	
	@RequestMapping(value = "/logout/success", method=RequestMethod.GET)
 	public String logoutSuccess() {
		String message = "Logout Success!";
		return "redirect:/login-form?message="+message;
	}
}
