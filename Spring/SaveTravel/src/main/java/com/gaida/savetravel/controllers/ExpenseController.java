package com.gaida.savetravel.controllers;

import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
		
		allExp.sort(Comparator.comparing(Expense::getAmount,(emp1, emp2) -> {
            return emp2.compareTo(emp1);
       }));
		
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
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable(value="id") long id, Model model) {
		
		model.addAttribute("exp", this.expService.findByID(id));
		System.out.println("id in get method-->" + this.expService.findByID(id).getId());
		
		return "edit.jsp";
	}
	
	@PutMapping("/update/{id}")
	public String update(@PathVariable(value="id") long id, @Valid @ModelAttribute("exp") Expense exp, BindingResult result ) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			System.out.println(exp.toString());
//			exp.setId(id);
			this.expService.updateExpense(exp);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/expense/{id}")
	public String details(@PathVariable(value="id") long id, Model model) {
		
		model.addAttribute("exp",this.expService.findByID(id)) ;
		
		return "details.jsp";
	}
	
	
	@DeleteMapping("/del/{id}")
	public String deleteExpense(@PathVariable(value="id") long id) {
		this.expService.deleteExpense(id);
		return "redirect:/";
	}

}
