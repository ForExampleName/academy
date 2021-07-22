package by.academy.homeworks.homework_2;

import java.util.Scanner;

public class WordFromTwoWords {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first word: ");
		String firstWord = scanner.nextLine();

		if (firstWord.length() % 2 != 0 || firstWord.length() == 0) {
			System.out.println("Word should has even lehgth");
			scanner.nextLine();
			scanner.close();
			return;
		}

		System.out.print("Enter second word: ");
		String secondWord = scanner.nextLine();

		if (secondWord.length() % 2 != 0 || secondWord.length() == 0) {
			System.out.println("Word should has even lehgth");
			scanner.nextLine();
			scanner.close();
			return;
		}

		StringBuilder resultWord = new StringBuilder();

		resultWord.append(firstWord.substring(0, firstWord.length() / 2));
		resultWord.append(secondWord.substring(secondWord.length() / 2, secondWord.length()));

		System.out.println(resultWord.toString());

		scanner.close();
	}
}