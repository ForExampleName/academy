package by.academy.homeworks.homework_3;

import by.academy.homeworks.homework_3.validators.EmailValidator;

public class EmailValidatorDemo {
	private static final EmailValidator emailValidator = new EmailValidator();

	public static void main(String[] args) {
		System.out.println(emailValidator.validate("pafos.email@mail.ru"));
		System.out.println(emailValidator.validate("pafos.email@gmail.com"));
		System.out.println(emailValidator.validate("pafos.Email@gmail.com"));
		System.out.println(emailValidator.validate("pafos.email@gmail.byyy"));
		System.out.println(emailValidator.validate("pafos.email.mail@gmail.byyy"));
	}
}