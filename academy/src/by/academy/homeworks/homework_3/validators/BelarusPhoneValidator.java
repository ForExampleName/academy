package by.academy.homeworks.homework_3.validators;

import java.util.regex.Pattern;

public class BelarusPhoneValidator implements Validator {
	protected static final String REGEX_PATTERN_STRING;
	protected static final Pattern pattern;
//	protected Matcher matcher; ???

	static {
		REGEX_PATTERN_STRING = new String("\\+375\\d{9}");
		pattern = Pattern.compile(REGEX_PATTERN_STRING);
	}

	public BelarusPhoneValidator() {
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
