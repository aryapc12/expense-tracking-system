package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;
import java.util.List;

public interface ExpenseService {

	List<Expense> findAll();
    Expense findById(Long id);
    Expense save(Expense expense);
    void deleteById(Long id);
    List<Expense> findByAmount(Double amount); // Method to find expenses by amount
}
