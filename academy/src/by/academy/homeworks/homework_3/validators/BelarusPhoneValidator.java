package by.academy.homeworks.homework_3.validators;

import java.util.regex.Pattern;

public class BelarusPhoneValidator implements Validator {
	protected static final Pattern pattern;

	static {
		pattern = Pattern.compile("\\+375\\d{9}");
	}

	public BelarusPhoneValidator() {
		super();
	}

	public boolean validate(String toValidate) {
		if (pattern.matcher(toValidate).matches()) {
			return true;
		}
		return false;
	}
}