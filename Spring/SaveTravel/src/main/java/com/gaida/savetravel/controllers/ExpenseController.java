package com.gaida.savetravel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gaida.savetravel.models.Expense;
import com.gaida.savetravel.services.ExpenseService;

@Controller
public class ExpenseController {
	
	private final ExpenseService expService;
	
	public ExpenseController(ExpenseService expService) {
		this.expService = expService;
		
	}
	
	@GetMapping("/")
	public String homePage(@ModelAttribute("exp") Expense exp,Model model) {
		List<Expense> allExp =  expService.findAll();
		
		model.addAttribute("allExp",allExp);
		
		return "index.jsp";
	}
	
	@PostMapping("/addExpense")
	public String addExpense(@Valid @ModelAttribute("exp")Expense exp,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			List<Expense> allExp =  expService.findAll();
			
			model.addAttribute("allExp",allExp);
			return "index.jsp";
		}
		else {
			expService.create(exp);
		}
		
		return "redirect:/";
	}
	
	

}
