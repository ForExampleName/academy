package by.academy.tasks.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task4 {
	private static final Random random = new Random();
	private static final Scanner scanner = new Scanner(System.in);

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

		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(rightBorder - leftBorder + 1) + leftBorder;
		}

		System.out.println(Arrays.toString(array));

		for (int i = 0; i < array.length; i++) {
			if ((i & 1) != 0) {
				array[i] = 0;
			}
		}

		System.out.println(Arrays.toString(array));

		scanner.close();
	}
}