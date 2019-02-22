package com.atmosphere.gotcha.spring.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import com.atmosphere.gotcha.spring.constraints.validator.PositiveLongArrayValidator;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE  })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(PositiveLongArray.List.class)
@Constraint(validatedBy = { PositiveLongArrayValidator.class })
public @interface PositiveLongArray {

	String message() default "{com.atmosphere.gotcha.spring.constraints.PositiveLongArray.message}";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE  })
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		PositiveLongArray[] value();
	}
}