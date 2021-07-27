package by.academy.homeworks.homework_3.validators;

import java.util.Scanner;

public class ValidatorDemo {
	private static final Scanner scanner = new Scanner(System.in);

	private static final AmericanPhoneValidator americanPhoneValidator = new AmericanPhoneValidator();
	private static final BelarusPhoneValidator belarusPhoneValidator = new BelarusPhoneValidator();
	private static final EmailValidator emailValidator = new EmailValidator();

	public static void main(String[] args) {

		String exit = new String();

		do {
			System.out.print("Enter american phone number: ");
			String phoneNumber = scanner.nextLine();

			if (americanPhoneValidator.validate(phoneNumber)) {
				System.out.println("Correct");
			} else {
				System.out.println("Uncorrect");
			}

			System.out.print("Enter belarusian phone number: ");
			phoneNumber = scanner.nextLine();

			if (belarusPhoneValidator.validate(phoneNumber)) {
				System.out.println("Correct");
			} else {
				System.out.println("Uncorrect");
			}

			System.out.print("Enter email: ");
			String email = scanner.nextLine();

			if (emailValidator.validate(email)) {
				System.out.println("Correct");
			} else {
				System.out.println("Uncorrect");
			}

			System.out.print("Continue? (yes/no): ");
			exit = scanner.nextLine();

		} while (!exit.equals("no"));

		scanner.close();
	}
}