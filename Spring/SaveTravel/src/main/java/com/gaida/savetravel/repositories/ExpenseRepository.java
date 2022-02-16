package com.gaida.savetravel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaida.savetravel.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense,Long>{

}
