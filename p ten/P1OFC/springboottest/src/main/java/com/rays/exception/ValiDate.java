package com.rays.exception;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.rays.validation.DateValidator;

@Constraint(validatedBy = DateValidator.class)
@Target({ ElementType.FIELD }) 
@Retention(RetentionPolicy.RUNTIME)
public @interface ValiDate {
	String message() default "Invalid date";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	
}
