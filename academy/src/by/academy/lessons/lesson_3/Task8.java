package by.academy.lessons.lesson_3;

import java.util.Scanner;

public class Task8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter iteration number: ");

		int temp = 0;
		int times = scanner.nextInt();

		for (int i = 1; i <= times; i++) {
			temp += i;
		}

		System.out.println("Sum is " + temp);

		temp = 1;

		for (int i = 1; i <= times; i++) {
			temp *= i;
		}

		System.out.println("Multiplication is " + temp);

		scanner.close();
	}

}
