package com.sprsec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
	public String login(Model model, @RequestParam(required=false) String msg, @RequestParam(required=false) String error) {
		model.addAttribute("msg", msg);
		model.addAttribute("error", error);
		return "access/login-form";
	}
	
	@RequestMapping(value = "/denied", method=RequestMethod.GET)
 	public String denied(ModelMap model) {
		
		return "access/denied";
	}
	
	@RequestMapping(value = "/login/failure", method=RequestMethod.GET)
 	public String loginFailure() {		
		String msg = "Login Failure!";	
		String error = "true";
		
		return "redirect:/login-form?msg="+msg+"&error="+error;
	}
	
	@RequestMapping(value = "/logout/success", method=RequestMethod.GET)
 	public String logoutSuccess() {
		String msg = "Logout Success!";
		return "redirect:/login-form?msg="+msg;
	}
}
