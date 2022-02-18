package com.gaida.dojoandninja.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gaida.dojoandninja.models.Dojo;
import com.gaida.dojoandninja.models.Ninja;
import com.gaida.dojoandninja.services.AppService;

@Controller
public class HomeController {
	
	private final AppService appService;
	
	public HomeController(AppService appService) {
		this.appService=appService;
	}
	
	@GetMapping("/")
	public String goHome() {
		return "redirect:/dojo";
	}
	
	@GetMapping("/dojo")
	public String home(Model model) {
		model.addAttribute("allDojos" ,this.appService.findAllDojo());
		Dojo theDojo = new Dojo();
		model.addAttribute("theDojo",theDojo);
		return "index.jsp";
	}
	
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("theDojo") Dojo nDojo, BindingResult results,Model model) {
		
				
		if(results.hasErrors()) {
			return "index.jsp";
		}
		else {
			this.appService.createDojo(nDojo);
		}
		model.addAttribute("allDojos" ,this.appService.findAllDojo());
		return "index.jsp";
	}

	@GetMapping("/ninja/add")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja,Model model) {
		model.addAttribute("dojoList",this.appService.findAllDojo());
		return "ninja.jsp";		
	}
	
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult results,Model model){
		
		if(results.hasErrors()) {
			model.addAttribute("dojoList",this.appService.findAllDojo());
			return "ninja.jsp";
		}
		else {
			this.appService.createNinja(ninja);
			return "redirect:/dojo";
		}
	}
	
	@GetMapping("/dojo/{id}/students")
	public String dojoStudents(@PathVariable("id") long id,Model model) {
		model.addAttribute("dojo", this.appService.findByIDDojo(id));		
		return "dojoStudents.jsp";
	}
	
}
