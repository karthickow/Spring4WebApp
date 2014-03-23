package com.maven.spring.hibernate.app.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String printWelcome(ModelMap modelMap, Principal principal){
		
		String name  =  principal.getName();
		modelMap.addAttribute("username", name);
		modelMap.addAttribute("message", "Spring Security Custom Form example");
		
		return "welcome";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(ModelMap modelMap){
		return "login";
	}

	@RequestMapping(value="/loginFailed", method=RequestMethod.GET)
	public String loginerror(ModelMap modelMap){		
		modelMap.addAttribute("error", "true");		
		return "login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(ModelMap modelMap){
		return "login";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.GET)
	public String home(ModelMap modelMap){
		return "login";
	}	
}
