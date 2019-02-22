package com.creditSuisse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CommonViewController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView defaultPage(ModelAndView modelViewObj) {
		modelViewObj.setViewName("index");
		return modelViewObj;
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public ModelAndView loginPage(ModelAndView modelViewObj) {
		modelViewObj.setViewName("index");
		return modelViewObj;
	}
	
	@RequestMapping(path="/password-reset", method=RequestMethod.GET)
	public ModelAndView passwordresetPage(ModelAndView modelViewObj) {
		modelViewObj.setViewName("password-reset");
		return modelViewObj;
	}
	
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public ModelAndView registerPage(ModelAndView modelViewObj) {
		modelViewObj.setViewName("register");
		return modelViewObj;
	}
	
	@RequestMapping(path="/forgot-password", method=RequestMethod.GET)
	public ModelAndView forgotPasswordPage(ModelAndView modelViewObj) {
		modelViewObj.setViewName("forgot-password");
		return modelViewObj;
	}
	
	@RequestMapping(path="/faq", method=RequestMethod.GET)
	public ModelAndView faqPage(ModelAndView modelViewObj) {
		modelViewObj.setViewName("faq");
		return modelViewObj;
	}
	
	@RequestMapping(path="/about-us", method=RequestMethod.GET)
	public ModelAndView aboutUsPage(ModelAndView modelViewObj) {
		modelViewObj.setViewName("about-us");
		return modelViewObj;
	}	
	
	@RequestMapping(path="/contact-us", method=RequestMethod.GET)
	public ModelAndView contactUsPage(ModelAndView modelViewObj) {
		modelViewObj.setViewName("contact-us");
		return modelViewObj;
	}
	
}
