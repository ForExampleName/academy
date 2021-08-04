package by.academy.homeworks.homework_3.validators;

import java.util.regex.Pattern;

public class EmailValidator implements Validator {
	protected static final Pattern pattern = Pattern.compile("[a-z.]+@[a-z]+\\.[a-z]{2,3}");

	public EmailValidator() {
		super();
	}

	public boolean validate(String toValidate) {
		return pattern.matcher(toValidate).matches();
	}
}