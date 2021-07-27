package by.academy.tasks.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task6 {
	private static final Random random = new Random();
	private static final Scanner scanner = new Scanner(System.in);

	private static boolean isArrayHasAscendingOrder(int[] array) {
		if (array.length == 1) {
			return true;
		}
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.print("Enter left border of the segment: ");
		int leftBorder = scanner.nextInt();

		System.out.print("Enter right border of the segment: ");
		int rightBorder = scanner.nextInt();

		if (leftBorder > rightBorder) {
			int temp = rightBorder;
			rightBorder = leftBorder;
			leftBorder = temp;
		}

		System.out.print("Enter array size: ");
		int arraySize = scanner.nextInt();

		if (arraySize == 0) {
			scanner.close();
			return;
		}

		int[] array = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {
			array[i] = random.nextInt(rightBorder - leftBorder + 1) + leftBorder;
		}

		System.out.println(Arrays.toString(array));

		if (isArrayHasAscendingOrder(array))
			System.out.println("There is ascending order of items in the array");
		else
			System.out.println("There is no ascending order of items in the array");

		scanner.close();
	}
}