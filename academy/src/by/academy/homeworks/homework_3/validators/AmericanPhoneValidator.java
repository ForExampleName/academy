package by.academy.homeworks.homework_3.validators;

import java.util.regex.Pattern;

public class AmericanPhoneValidator implements Validator {
	protected static final Pattern pattern = Pattern.compile("\\+1\\d{10}");

	public AmericanPhoneValidator() {
		super();
	}

	public boolean validate(String toValidate) {
		return pattern.matcher(toValidate).matches();
	}
}