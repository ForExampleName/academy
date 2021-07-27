package by.academy.tasks.arrays;

import java.util.Scanner;

public class Task2 {
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

		int oddCount = ((leftBorder & 1) == 0 && (rightBorder & 1) == 0) ? (rightBorder - leftBorder) / 2
				: (rightBorder - leftBorder) / 2 + 1;

		if (oddCount == 0) {
			scanner.close();
			return;
		}

		int[] array = new int[oddCount];

		int startValue = (leftBorder & 1) == 1 ? leftBorder : leftBorder + 1;
		for (int i = 0; i < array.length; i++) {
			array[i] = startValue;
			startValue += 2;
		}

		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}

		scanner.close();
	}
}