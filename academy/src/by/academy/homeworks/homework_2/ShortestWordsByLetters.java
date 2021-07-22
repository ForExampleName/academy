package by.academy.homeworks.homework_2;

import java.util.Scanner;

public class ShortestWordsByLetters {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("How many word would you like to enter?");
		int wordCount = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Enter your words:");

		String[] words = new String[wordCount];

		for (int i = 0; i < wordCount; i++) {
			words[i] = scanner.nextLine();
		}

		int length;
		int minLength = Integer.MAX_VALUE;

		int pos;

		for (int i = 0; i < wordCount; i++) {
			StringBuilder template = new StringBuilder(words[i]);

			for (int j = 0; j < template.length() - 1; j++) {
				pos = j;

				while ((pos = template.toString().indexOf(template.charAt(j), pos + 1)) != -1) {
					template.deleteCharAt(pos);
				}
			}

			length = template.toString().length();

			if (length < minLength) {
				minLength = length;
			}
		}

		for (String word : words) {
			if (word.length() == minLength) {
				System.out.println(word);
				break;
			}
		}

		scanner.close();
	}
}