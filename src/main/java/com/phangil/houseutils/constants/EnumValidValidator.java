package com.phangil.houseutils.constants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValidValidator implements ConstraintValidator<EnumValid, Enum> {

	@Override
	public void initialize(EnumValid constraintAnnotation) {
		System.out.println(constraintAnnotation.message());
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Enum value, ConstraintValidatorContext constraintValidatorContext) {
		System.out.println("여기는 isValid: " + value);
		if(value == null)
			System.out.println("null 이다");
		return value != null;
	}

}

