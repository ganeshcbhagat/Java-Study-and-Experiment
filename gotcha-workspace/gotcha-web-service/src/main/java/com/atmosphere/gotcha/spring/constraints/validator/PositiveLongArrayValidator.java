package com.atmosphere.gotcha.spring.constraints.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atmosphere.gotcha.spring.constraints.PositiveLongArray;

public class PositiveLongArrayValidator implements ConstraintValidator<PositiveLongArray, Object> {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	private PositiveLongArray constraintAnnotation;
	
	@Override
	public void initialize(PositiveLongArray constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
		this.constraintAnnotation=constraintAnnotation;
	}

	@Override
	public boolean isValid(Object objectToValidate, ConstraintValidatorContext context) {
		Boolean valid = false;
		LOG.info("Validating Long Array start.");
		if(objectToValidate instanceof Long[]) {
			Long numbers[] = (Long[])objectToValidate;
			for(Long number : numbers) {
				if(number.longValue()<=0) {
					valid = false;
					break;
				} else {
					valid = true;
				}
			}
		    
		    if (!valid) {
		        context.disableDefaultConstraintViolation();
		        context.buildConstraintViolationWithTemplate(constraintAnnotation.message()).addConstraintViolation();
		    }
		}
		LOG.info("Validating Long Array is completed.");
		return valid;
	}

}
