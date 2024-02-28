package com.example.expensetracker.repository;

import com.example.expensetracker.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

	Optional<Expense> findByNameIgnoreCase(String name);
	List<Expense> findByAmount(Double amount); // New method to find expenses by amount
}
