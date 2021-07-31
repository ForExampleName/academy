package by.academy.homeworks.homework_3;

import by.academy.homeworks.homework_3.validators.AmericanPhoneValidator;
import by.academy.homeworks.homework_3.validators.BelarusPhoneValidator;

public class PhoneValidatorDemo {
	private static final AmericanPhoneValidator americanPhoneValidator = new AmericanPhoneValidator();
	private static final BelarusPhoneValidator belarusPhoneValidator = new BelarusPhoneValidator();

	public static void main(String[] args) {
		System.out.println(americanPhoneValidator.validate("+19876583920"));
		System.out.println(americanPhoneValidator.validate("+59876583920"));
		System.out.println(americanPhoneValidator.validate("+59876920"));
		System.out.println(americanPhoneValidator.validate("+598765834567920"));

		System.out.println();

		System.out.println(belarusPhoneValidator.validate("+375296587436"));
		System.out.println(belarusPhoneValidator.validate("+373296587436"));
		System.out.println(belarusPhoneValidator.validate("+37529658743"));
		System.out.println(belarusPhoneValidator.validate("+37529658877436"));
	}
}