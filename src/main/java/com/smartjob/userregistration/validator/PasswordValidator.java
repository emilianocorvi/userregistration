package com.smartjob.userregistration.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Value;

import com.smartjob.userregistration.annotation.Password;

public class PasswordValidator implements ConstraintValidator<Password, String> {

	@Value("${validation.password.pattern}")
	private String regex;

	public boolean isValid(String chars, ConstraintValidatorContext context) {
		Pattern pattern = Pattern.compile(regex);
		if (!pattern.matcher(chars).find()) {
			context.buildConstraintViolationWithTemplate("Debe matchear con la regex configurada por property: " + regex).addConstraintViolation().disableDefaultConstraintViolation();
			return false;
		}
		return true;
	}
}