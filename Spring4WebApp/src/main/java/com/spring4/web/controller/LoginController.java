package com.spring4.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String printWelcome(ModelMap modelMap, Principal principal){
		
		System.out.println("********LoginController Called********");
		
		String name  =  principal.getName();
		modelMap.addAttribute("username", name);
		modelMap.addAttribute("message", "Spring Security Custom Form example");
		
		return "hello";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(ModelMap modelMap){
		return "login";
	}

	@RequestMapping(value="/loginfailed", method=RequestMethod.GET)
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
		return "home";
	}	
}
