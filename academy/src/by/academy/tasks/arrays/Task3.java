package by.academy.tasks.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		Random random = new Random();

		Scanner scanner = new Scanner(System.in);

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

		int count = 0;

		for (int val : array) {
			if ((val & 1) == 0 && val != 0)
				++count;
		}

		System.out.println(count + " even entries in array");

		scanner.close();
	}
}