package by.academy.homeworks.homework_3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateChecker {
	private static Pattern pattern1 = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
	private static Pattern pattern2 = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter your date in format dd/MM/yyyy: ");

		String date = scanner.nextLine();

		Matcher matcher = pattern1.matcher(date);

		if (matcher.matches())
			System.out.println("Correct");
		else
			System.out.println("Uncorrect");

		System.out.print("Now enter your date in format dd-MM-yyyy: ");

		date = scanner.nextLine();

		matcher = pattern2.matcher(date);

		if (matcher.matches())
			System.out.println("Correct");
		else
			System.out.println("Uncorrect");

		scanner.close();
	}
}