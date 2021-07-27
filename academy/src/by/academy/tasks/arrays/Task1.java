package by.academy.tasks.arrays;

import java.util.Scanner;

public class Task1 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter left border of the sequence: ");
		int leftBorder = scanner.nextInt();

		System.out.print("Enter right border of the sequence: ");
		int rightBorder = scanner.nextInt();

		if (leftBorder > rightBorder) {
			int temp = rightBorder;
			rightBorder = leftBorder;
			leftBorder = temp;
		}

		int evenCount;

		if ((leftBorder & 1) == 0 || (rightBorder & 1) == 0) { // +1
			if (leftBorder == 0 || rightBorder == 0) {// +0
				evenCount = (rightBorder - leftBorder) / 2;
			} else if (leftBorder < 0 && rightBorder > 0) {// +0
				evenCount = (rightBorder - leftBorder) / 2;
			} else {// +1
				evenCount = (rightBorder - leftBorder) / 2 + 1;
			}
		} else { // +0
			if (leftBorder < 0 && rightBorder > 0) {// +0
				evenCount = (rightBorder - leftBorder) / 2 - 1;
			} else {
				evenCount = (rightBorder - leftBorder) / 2;
			}
		}

		if (evenCount == 0) {
			scanner.close();
			return;
		}

		int[] array = new int[evenCount];

		int currentValue;

		if ((leftBorder & 1) == 0) {
			if (leftBorder == 0) {
				currentValue = leftBorder + 2;
			} else {
				currentValue = leftBorder;
			}
		} else {
			if (leftBorder + 1 == 0) {
				currentValue = leftBorder + 3;
			} else {
				currentValue = leftBorder + 1;
			}
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = currentValue;

			currentValue += 2;

			if (currentValue == 0)
				currentValue += 2;
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		scanner.close();
	}
}