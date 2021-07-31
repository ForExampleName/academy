package by.academy.homeworks.homework_3.validators;

import java.util.regex.Pattern;

public class DateValidator implements Validator {
	private static Pattern pattern1;
	private static Pattern pattern2;

	static {
		pattern1 = Pattern.compile("[0-3]\\d/[0-1]\\d/[0-2]\\d{3}");
		pattern2 = Pattern.compile("[0-3]\\d-[0-1]\\d-[0-2]\\d{3}");
	}

	public DateValidator() {
		super();
	}

	public boolean validate(String toValidate) {
		if (pattern1.matcher(toValidate).matches() || pattern2.matcher(toValidate).matches()) {
			return true;
		}
		return false;
	}
}