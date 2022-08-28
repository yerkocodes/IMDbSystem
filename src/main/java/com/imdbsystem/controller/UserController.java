package com.imdbsystem.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.imdbsystem.model.Role;
import com.imdbsystem.model.Users;
import com.imdbsystem.service.ShowService;
import com.imdbsystem.service.UsersService;
import com.imdbsystem.utils.Utils;

@Controller
public class UserController {

//	UserController (métodos diferenciados para login y registro)
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private ShowService showService;
	
	// >>> ROOT ---------------------------------------
	@GetMapping({"/"})
	public RedirectView root() {
		return new RedirectView("/login");
	}
	
	// >>> LOGIN --------------------------------------
	@GetMapping("/login")
	public ModelAndView login(Principal principal) {

		ModelAndView model = new ModelAndView();
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    
	    if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"))) {
	    	model.setViewName("redirect:/user");
		}

		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
	    	model.setViewName("redirect:/admin");
		}

		if (auth == null) {
			model.setViewName("login");
		}
	    
		model.addObject("statusSession", Utils.sessionStatus(principal));
		return model;
	}
	
	// >>> LOGOUT -------------------------------------
	@GetMapping("/logout")
	public RedirectView logout() {
		return new RedirectView("/login");
	}
	
	// >>> RESGISTER ----------------------------------
	@GetMapping("/registration")
	public ModelAndView signup(Principal principal) {
		ModelAndView model = new ModelAndView("registration"); // >>> JSP /admin/home.jsp
		model.addObject("statusSession", Utils.sessionStatus(principal));
		return model;
	}
	
	@PostMapping("/register")
	public RedirectView register(@ModelAttribute Users user) {
		usersService.add(user);
		return new RedirectView("/login");
	}
	
	// >>> ADMIN --------------------------------------
	@GetMapping("/admin")
	public ModelAndView adminHome(Principal principal) {
		ModelAndView model = new ModelAndView("/admin/home"); // >>> JSP /admin/home.jsp
		model.addObject("statusSession", Utils.sessionStatus(principal));
		model.addObject("session", principal.getName());
		model.addObject("shows", showService.findAllShow());
		return model;
	}
	
	// >>> USER ---------------------------------------
	@GetMapping("/user")
	public ModelAndView userHome(Principal principal) {
		ModelAndView model = new ModelAndView("/user/home"); // >>> JSP /admin/home.jsp
		
		model.addObject("statusSession", Utils.sessionStatus(principal));
		model.addObject("session", principal.getName());
		model.addObject("shows", showService.findAllShow());
		System.out.println("Lista de shows" + showService.findAllShow());
		return model;
	}
	
}
