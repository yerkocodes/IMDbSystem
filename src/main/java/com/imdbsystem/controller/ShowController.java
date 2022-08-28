package com.imdbsystem.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.imdbsystem.model.Show;
import com.imdbsystem.service.ShowService;
import com.imdbsystem.utils.Utils;

@Controller
public class ShowController {
	
//	ShowController (aquí debe ir el método para agregar Rating también.)
	
	@Autowired
	private ShowService showService;
	
	@GetMapping("/showDetails")
	public ModelAndView showDetails(@RequestParam("showId") long showId, Principal principal) {
		ModelAndView model = new ModelAndView("/user/showDetail");
		model.addObject("show", showService.findById(showId));
		model.addObject("statusSession", Utils.sessionStatus(principal));
		return model;
	}
	
	// RATING -----------------------------------------------------
	@PostMapping("/changeRating")
	public ModelAndView changeRating(@RequestParam("showId") long showId, @RequestParam("rating") String stars) {
		System.out.println(showId);
		System.out.println(stars);
		return null;
	}

	// UPDATE SHOW -----------------------------------------------------
	@GetMapping("/show/edit")
	public ModelAndView updateShow(@RequestParam("showId") long showId, Principal principal) {
		ModelAndView model = new ModelAndView("/user/edit");
		model.addObject("showToUpdate", showService.findById(showId));
		model.addObject("statusSession", Utils.sessionStatus(principal));
		return model;
	}
	
	@PostMapping("/edit")
	public RedirectView update(@ModelAttribute("updateShowForm") Show show) {
		showService.add(show);
		return new RedirectView("/");
	}
	
	// ADD SHOW -----------------------------------------------------------
	@GetMapping("/show/add")
	public ModelAndView addShow(Principal principal) {
		ModelAndView model = new ModelAndView("/user/new");
		model.addObject("statusSession", Utils.sessionStatus(principal));
		return model;
	}

	@PostMapping("/add")
	public RedirectView add(@ModelAttribute("addShowForm") Show show) {
		showService.add(show);
		return new RedirectView("/");
	}

	// DELETE SHOW -----------------------------------------------------------
	@GetMapping("/show/delete")
	public RedirectView add(@RequestParam("showId") long showId) {
		showService.delete(showService.findById(showId));
		return new RedirectView("/");
	}
}
