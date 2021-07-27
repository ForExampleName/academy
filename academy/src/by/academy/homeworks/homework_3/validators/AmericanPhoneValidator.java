package by.academy.homeworks.homework_3.validators;

import java.util.regex.Pattern;

public class AmericanPhoneValidator implements Validator {
	protected static final String REGEX_PATTERN_STRING;
	protected static final Pattern pattern;

	static {
		REGEX_PATTERN_STRING = new String("\\+1\\d{10}");
		pattern = Pattern.compile(REGEX_PATTERN_STRING);
	}

	public AmericanPhoneValidator() {
		super();
	}

	public boolean validate(String template) {
		if (pattern.matcher(template).matches()) {
			return true;
		}
		return false;
	}

	// equals, hashcode, toString ?
}