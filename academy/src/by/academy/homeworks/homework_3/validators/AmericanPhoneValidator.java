package by.academy.homeworks.homework_3.validators;

import java.util.regex.Pattern;

public class AmericanPhoneValidator implements Validator {
	protected static final Pattern pattern;

	static {
		pattern = Pattern.compile("\\+1\\d{10}");
	}

	public AmericanPhoneValidator() {
		super();
	}

	public boolean validate(String toValidate) {
		if (pattern.matcher(toValidate).matches()) {
			return true;
		}
		return false;
	}
}