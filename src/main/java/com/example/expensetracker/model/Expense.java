package com.example.expensetracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
public class Expense {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull(message="Amount cannot be null")
	@DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private Double amount;

	@NotNull(message = "Date cannot be null")
    @PastOrPresent(message = "Date cannot be in the future")
    @Temporal(TemporalType.DATE)
    private Date date;
	
	@NotNull(message = "Expense name cannot be null")
    @Size(min = 2, message = "Expense name must be at least 2 characters long")
    private String name;

    // Default constructor
    public Expense() {
    }

    // Constructor with parameters
    public Expense(Double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
