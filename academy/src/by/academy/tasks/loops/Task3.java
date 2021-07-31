package by.academy.tasks.loops;

import java.util.Scanner;

public class Task3 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n;
		do {
			System.out.print("Enter border number of sequence (>1): ");
			n = scanner.nextInt();
		} while (n <= 1);

		int mult = 1;

		for (int i = 1; i <= n; i++) {
			mult *= i;
		}

		System.out.println(mult);

		scanner.close();
	}
}