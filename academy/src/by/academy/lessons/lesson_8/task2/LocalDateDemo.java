package by.academy.lessons.lesson_8.task2;

import java.time.LocalDate;
import java.util.Scanner;

public class LocalDateDemo {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter your birthday date: ");
		String birthdayStr = scanner.nextLine();

		// format: yyyy-MM-dd
		LocalDate birthdayDate = LocalDate.parse(birthdayStr);

		System.out.println(birthdayDate.getYear());
		System.out.println(birthdayDate.getMonth());
		System.out.println(birthdayDate.getDayOfYear());
		System.out.println(birthdayDate.getDayOfWeek());

		LocalDate now = LocalDate.now();

		if (birthdayDate.isBefore(now)) {
			System.out.println("Birthday is before now");
		} else if (birthdayDate.isAfter(now)) {
			System.out.println("Birthday is after now");
		} else if (birthdayDate.equals(now)) {
			System.out.println("Birthday is today");
		}

		scanner.close();
	}
}