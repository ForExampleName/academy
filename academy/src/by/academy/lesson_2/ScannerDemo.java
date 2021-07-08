package by.academy.lesson_2;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		System.out.println(message);
		scanner.close();
		System.out.println("Good bye.");
	}

}
