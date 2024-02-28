package com.example.expensetracker.controller;

import com.example.expensetracker.dto.ExpenseUpdateDTO;
import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
    
    // New endpoint to get expenses by amount
    @GetMapping("/by-amount")
    public List<Expense> getExpensesByAmount(@RequestParam Double amount) {
        return expenseService.findByAmount(amount);
    }
    // /expenses/by-amount?amount=100.5

    @PostMapping
    public Expense createExpense(@Valid @RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @Valid @RequestBody Expense expenseDetails) {
        Expense expense = expenseService.findById(id);
        expense.setName(expenseDetails.getName());
        expense.setAmount(expenseDetails.getAmount());
        expense.setDate(expenseDetails.getDate());
        return expenseService.save(expense);
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Expense> updateExpensePartial(@PathVariable Long id, @RequestBody ExpenseUpdateDTO expenseUpdateDTO) {
        Expense expense = expenseService.findById(id);

        if (expense == null) {
            return ResponseEntity.notFound().build();
        }

        if (expenseUpdateDTO.getAmount() != null) {
            expense.setAmount(expenseUpdateDTO.getAmount());
        }
        if (expenseUpdateDTO.getDate() != null) {
            expense.setDate(expenseUpdateDTO.getDate());
        }
        if (expenseUpdateDTO.getName() != null && !expenseUpdateDTO.getName().isEmpty()) {
            expense.setName(expenseUpdateDTO.getName());
        }
        
        Expense updatedExpense = expenseService.save(expense);
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        expenseService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
