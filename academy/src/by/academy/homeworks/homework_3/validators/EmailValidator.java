package by.academy.homeworks.homework_3.validators;

import java.util.regex.Pattern;

public class EmailValidator implements Validator {
	protected static final String REGEX_PATTERN_STRING;
	protected static final Pattern pattern;
//	protected Matcher matcher; ???

	static {
		REGEX_PATTERN_STRING = new String("[a-z.]+@[a-z]+\\.[a-z]{2,3}");
		pattern = Pattern.compile(REGEX_PATTERN_STRING);
	}

	public EmailValidator() {
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
