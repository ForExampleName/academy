package by.academy.homeworks.homework_3.validators;

import java.util.regex.Pattern;

public class BelarusPhoneValidator implements Validator {
	protected static final Pattern pattern = Pattern.compile("\\+375\\d{9}");

	public BelarusPhoneValidator() {
		super();
	}

	public boolean validate(String toValidate) {
		return pattern.matcher(toValidate).matches();
	}
}