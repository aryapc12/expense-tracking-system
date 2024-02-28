package com.example.expensetracker.validation;

import com.example.expensetracker.repository.ExpenseRepository;
import com.example.expensetracker.validation.CaseInsensitiveUniqueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component // Make this class a Spring-managed bean to support Autowiring
public class CaseInsensitiveUniqueNameValidator implements ConstraintValidator<CaseInsensitiveUniqueName, String>{

	@Autowired
    private ExpenseRepository expenseRepository;
	
	@Override
    public void initialize(CaseInsensitiveUniqueName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Not the responsibility of this validator
        }
        
        // Use the repository to check for the existence of the expense by name, ignoring case
        return expenseRepository.findByNameIgnoreCase(value).isEmpty();
        
    }
}
