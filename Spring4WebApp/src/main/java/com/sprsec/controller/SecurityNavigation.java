package com.sprsec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityNavigation {
	
	@RequestMapping(value="/user-login", method=RequestMethod.GET)
	public ModelAndView loginForm() {
		return new ModelAndView("login-form");
	}
	
	@RequestMapping(value="/error-login", method=RequestMethod.GET)
	public ModelAndView invalidLogin() {
		ModelAndView modelAndView = new ModelAndView("login-form");
		modelAndView.addObject("error", true);
		return modelAndView;
	}
	
	@RequestMapping(value="/success-login", method=RequestMethod.GET)
	public ModelAndView successLogin() {
		return new ModelAndView("success-login");
	}
	
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
}
