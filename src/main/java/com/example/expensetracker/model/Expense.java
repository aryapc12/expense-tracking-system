package com.example.expensetracker.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Expense {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Temporal(TemporalType.DATE)
    private Date date;

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
}
