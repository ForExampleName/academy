package by.academy.tasks.loops;

import java.util.Scanner;

public class Task4 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter iteration number: ");
		int n = scanner.nextInt();

		int positiveCount = 0;
		int negativeCount = 0;
		int zeroCount = 0;

		int currentNum = 0;

		for (int i = 0; i < n; i++) {
			currentNum = scanner.nextInt();
			if (currentNum > 0) {
				++positiveCount;
			} else if (currentNum < 0) {
				++negativeCount;
			} else {
				++zeroCount;
			}
		}

		System.out.println("Positive count: " + positiveCount);
		System.out.println("Negative count: " + negativeCount);
		System.out.println("Zeros: " + zeroCount);

		scanner.close();
	}
}