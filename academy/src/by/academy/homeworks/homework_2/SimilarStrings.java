package by.academy.homeworks.homework_2;

import java.util.Scanner;

public class SimilarStrings {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter first word: ");
		String firstWord = scanner.nextLine();

		System.out.print("Enter second word: ");
		String secondWord = scanner.nextLine();

		if (firstWord.length() != secondWord.length()) {
			System.out.println(false);
			scanner.close();
			return;
		}

		int result1 = 0;
		int result2 = 0;

		for (int i = 0; i < firstWord.length(); i++) {
			result1 ^= firstWord.charAt(i);
		}

		for (int i = 0; i < secondWord.length(); i++) {
			result2 ^= secondWord.charAt(i);
		}

		System.out.println(result1 == result2);

		scanner.close();
	}
}