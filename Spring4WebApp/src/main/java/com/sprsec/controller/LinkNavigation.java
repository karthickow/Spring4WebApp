package com.sprsec.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LinkNavigation {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView homePage() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView indexPage() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/sec/moderation", method=RequestMethod.GET)
	public ModelAndView moderatorPage() {
		return new ModelAndView("moderation");
	}
	
	@RequestMapping(value="/admin/first", method=RequestMethod.GET)
	//public ModelAndView firstAdminPage() {
	public String firstAdminPage(ModelMap modelMap, Principal principal, final RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("username", principal.getName());
		redirectAttributes.addFlashAttribute("message", "Spring Security Custom Form example");
		
		return "redirect:/load";
		//return new ModelAndView("admin-first");
	}
	
	@RequestMapping(value="/admin/second", method=RequestMethod.GET)
	public ModelAndView secondAdminPage() {
		return new ModelAndView("admin-second");
	}

}
