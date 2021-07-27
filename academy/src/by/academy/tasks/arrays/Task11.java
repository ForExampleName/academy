package by.academy.tasks.arrays;

import java.util.Random;
import java.util.Scanner;

public class Task11 {
	private static final Random random = new Random();
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int arraySize = 0;
		do {
			System.out.print("Enter array size (must be positive and even): ");
			arraySize = scanner.nextInt();
		} while (arraySize <= 0 || (arraySize & 1) == 1);

		System.out.print("Enter left border of the segment: ");
		int leftBorder = scanner.nextInt();

		System.out.print("Enter right border of the segment: ");
		int rightBorder = scanner.nextInt();

		if (leftBorder > rightBorder) {
			int temp = rightBorder;
			rightBorder = leftBorder;
			leftBorder = temp;
		}

		int[] array = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {
			array[i] = random.nextInt(rightBorder - leftBorder + 1) + leftBorder;
			System.out.print(array[i] + " ");
		}

		int leftSum = 0;
		int rightSum = 0;

		for (int i = 0; i < array.length / 2; i++) {
			leftSum += (array[i] > 0) ? array[i] : -(array[i]);
		}

		for (int i = array.length / 2; i < array.length; i++) {
			rightSum += (array[i] > 0) ? array[i] : -(array[i]);
		}

		System.out.println();

		if (leftSum > rightSum) {
			System.out.println("Left summ is bigger");
		} else if (rightSum > leftSum) {
			System.out.println("Right summ is bigger");
		} else {
			System.out.println("Summs are equal");
		}

		scanner.close();
	}
}