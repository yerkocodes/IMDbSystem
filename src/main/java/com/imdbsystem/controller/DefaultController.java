package com.imdbsystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DefaultController {
	
	 @RequestMapping("/default")
	    public RedirectView defaultAfterLogin(HttpServletRequest request) {

	        if (request.isUserInRole("ADMIN")) {
	            return new RedirectView("/adminHola/");
	        } 
	        
	        if (request.isUserInRole("USER")) {
				return new RedirectView("/userHola/");
			}

			return null;
	    }

}
