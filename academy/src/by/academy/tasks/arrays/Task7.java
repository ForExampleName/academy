package by.academy.tasks.arrays;

import java.util.Scanner;

public class Task7 {
	private static final Scanner scanner = new Scanner(System.in);

	private static void fibonacciLoop(int count) {
		int current = 1;
		int next = 1;
		int temp;

		System.out.println(current);

		while (--count != 0) {
			temp = current;
			current = next;
			next = next + temp;

			System.out.println(current);
		}
	}

	private static void fibonacciRec(int current, int next, int count) {
		System.out.println(current);
		if (--count == 0)
			return;
		else
			fibonacciRec(next, current + next, count);
	}

	public static void main(String[] args) {
		System.out.print("Enter number of elements: ");
		int num = scanner.nextInt();

		if (num == 0) {
			scanner.close();
			return;
		}

		/* Using loops */
		System.out.println("Fibonacci sequence using loops: ");
		fibonacciLoop(num);

		System.out.println();

		/* Using recursion */
		System.out.println("Fibonacci sequence using recursion: ");
		fibonacciRec(1, 1, num);

		scanner.close();
	}
}