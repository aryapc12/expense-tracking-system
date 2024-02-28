package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.findAll();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.findById(id);
    }

    @PostMapping
    public Expense createExpense(@Valid @RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @Valid @RequestBody Expense expenseDetails) {
        Expense expense = expenseService.findById(id);
        expense.setAmount(expenseDetails.getAmount());
        expense.setDate(expenseDetails.getDate());
        return expenseService.save(expense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        expenseService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
