package com.aisino.cec.test.validation;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusValidator implements ConstraintValidator<Status, String> {
	private final String[] ALL_STATUS = { "0", "1"};

	public void initialize(Status status) {
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (Arrays.asList(ALL_STATUS).contains(value))
			return true;
		return false;
	}
}