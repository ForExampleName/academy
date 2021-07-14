package by.academy.homeworks.homework_2;

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = 1;

		for (int i = 0; i < 10; i++) {
			System.out.print("Enter integer number from 1 to 10: ");
			number = scanner.nextInt();

			System.out.println("\n\tMultiplication table for " + number + "\n");

			for (int multiplier = 1; multiplier <= 10; multiplier++) {
				System.out.println("\t\t" + number + " * " + multiplier + " = " + number * multiplier);
			}

			System.out.println();
		}

		scanner.close();
	}

}
