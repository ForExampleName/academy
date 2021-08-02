package by.academy.homeworks.homework_3;

import java.util.Scanner;

import by.academy.homeworks.homework_3.validators.DateValidator;

public class DateValidatorDemo {
	private static final DateValidator dateValidator = new DateValidator();

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter your date (use format dd/MM/yyyy or dd-MM-yyyy): ");
		String date = scanner.nextLine();

		if (dateValidator.validate(date)) {
			System.out.println("Correct date");
		} else {
			System.out.println("Not corect date");
		}

		scanner.close();
	}
}