package com.rays.validation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DoubleValidator implements ConstraintValidator<ValidDouble, Double> {

    @Override
    public void initialize(ValidDouble constraintAnnotation) {
        // Initialization logic (if needed)
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;  // Allow null if you handle null separately (e.g., @NotNull).
        }

        // Check if the value has a decimal part (i.e., it's a valid double, not an integer)
        return value % 1 != 0;
    }
}
