package com.gaida.savetravel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gaida.savetravel.models.Expense;
import com.gaida.savetravel.repositories.ExpenseRepository;

@Service
public class ExpenseService{
		
	// adding the expense repository as a dependency
		private final ExpenseRepository expRepo;
		
//constructor that has the repository injected into it (dependency injection) --> initializes the Service with connection to the repository
		public ExpenseService(ExpenseRepository expRepo) {
			this.expRepo = expRepo;
		}
		
		public List<Expense> findAll() {
			
			return (List<Expense>)	this.expRepo.findAll();
		}
		
		public void create(Expense expObj) {
			
			this.expRepo.save(expObj);
		}
		
		
		
		
}
