package by.academy.tasks.loops;

import java.util.Scanner;

public class Task2 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n;
		do {
			System.out.print("Enter border number of sequence (>1): ");
			n = scanner.nextInt();
		} while (n <= 1);

		int sum = 0;

		for (int i = 1; i <= n; i++) {
			sum += i;
		}

		System.out.println(sum);

		scanner.close();
	}
}