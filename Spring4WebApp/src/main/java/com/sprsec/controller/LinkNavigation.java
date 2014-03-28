package com.sprsec.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LinkNavigation {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getHomePage() {
		return "home";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String getUserPage() {
		return "user";
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String getAdminPage(ModelMap modelMap, Principal principal, final RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("username", principal.getName());
		redirectAttributes.addFlashAttribute("message", "Spring Security Custom Form example");
		
		return "redirect:/load";
	}
}
