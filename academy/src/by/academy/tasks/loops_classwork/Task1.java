package by.academy.tasks.loops_classwork;

import java.util.Scanner;

public class Task1 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int number = scanner.nextInt();

		if (number >= 0 && number <= 10) {
			System.out.println("Positive number less than 10 or equal 10");
		} else {
			System.out.println("Positive number bigger than 10 or negative");
		}

		scanner.close();
	}
}