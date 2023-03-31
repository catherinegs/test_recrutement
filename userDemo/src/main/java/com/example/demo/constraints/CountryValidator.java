package com.example.demo.constraints;




import java.util.Arrays;
import java.util.stream.Stream;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<Country, String> {
	
	String[] arrayOfString;
	
	@Override
	public void initialize(Country constraintAnnotation) {
		
		String[] values = constraintAnnotation.Values();
		this.arrayOfString = Stream.of(values).toArray(String[]::new );
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		arrayOfString = new String[] {"France"};
		
		return Arrays.asList(this.arrayOfString).contains(value);
	}

}
