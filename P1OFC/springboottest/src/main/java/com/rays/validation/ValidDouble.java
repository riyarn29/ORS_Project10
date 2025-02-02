package com.rays.validation;



	import javax.validation.Constraint;
	import javax.validation.Payload;
	import java.lang.annotation.ElementType;
	import java.lang.annotation.Retention;
	import java.lang.annotation.RetentionPolicy;
	import java.lang.annotation.Target;

	@Constraint(validatedBy = DoubleValidator.class)
	@Target({ElementType.FIELD, ElementType.PARAMETER})
	@Retention(RetentionPolicy.RUNTIME)
	public @interface ValidDouble {
	    String message() default "Latitude must be a double value (not an integer)";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
	}

