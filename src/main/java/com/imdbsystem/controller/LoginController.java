package com.imdbsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//@RequestMapping(path = "/login", method = RequestMethod.GET)
public class LoginController {
	
	@GetMapping("/")
	public RedirectView redirectHome() {
		return new RedirectView("/login");
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

}
