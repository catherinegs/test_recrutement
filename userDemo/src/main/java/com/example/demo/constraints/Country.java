package com.example.demo.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Constraint(validatedBy = CountryValidator.class)
public @interface Country {
	
	String[] Values();
	
	//error message
	public String message() default "only people who have a residence in France can to registre";
	
	//represents group of constraints 
	public Class<?>[] groups() default {};
	
	//represents additional information about annotation
	public Class<? extends Payload>[] payload() default {};
	
	

}
