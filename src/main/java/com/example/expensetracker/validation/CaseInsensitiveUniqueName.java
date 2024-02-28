package com.example.expensetracker.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = CaseInsensitiveUniqueNameValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface CaseInsensitiveUniqueName {

	String message() default "The name must be unique regardless of case";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
