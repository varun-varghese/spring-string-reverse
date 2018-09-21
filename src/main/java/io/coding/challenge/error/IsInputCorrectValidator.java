package io.coding.challenge.error;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsInputCorrectValidator implements ConstraintValidator<IsInputCorrect, String> {
	
	@Override
	public void initialize(IsInputCorrect constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String input, ConstraintValidatorContext context) {
		if (null == input) {
			context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Input should not be null").addConstraintViolation();
            return false;
		}
		
		if (input.isEmpty()) {
			context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Input should not be empty").addConstraintViolation();
            return false;
		}
		
		if (input.length() > 1024) {
			context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Input should be less than 1024 char").addConstraintViolation();
            return false;
		}
		
		return true;
	}

}
