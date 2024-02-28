package com.example.expensetracker.dto;

import java.util.Date;

public class ExpenseUpdateDTO {

	private Double amount;
    private Date date;
    private String name;
    
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
