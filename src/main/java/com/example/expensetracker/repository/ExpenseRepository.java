package com.example.expensetracker.repository;

import com.example.expensetracker.model.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
