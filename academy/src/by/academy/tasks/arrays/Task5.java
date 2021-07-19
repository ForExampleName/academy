package by.academy.tasks.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task5 {

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

		int[] array1 = new int[arraySize];
		int[] array2 = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {
			array1[i] = random.nextInt(rightBorder - leftBorder + 1) + leftBorder;
			array2[i] = random.nextInt(rightBorder - leftBorder + 1) + leftBorder;
		}

		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));

		int sum = 0;

		float average1 = 0;
		float average2 = 0;

		for (int value : array1) {
			sum += value;
		}

		average1 = Math.round(sum * 1000 / arraySize) / 1000.0F;

		sum = 0;

		for (int value : array2) {
			sum += value;
		}

		average2 = Math.round(sum * 1000 / arraySize) / 1000.0F;

		if (average1 > average2) {
			System.out.println("Average of first array is bigger ( " + average1 + " > " + average2 + " )");
		} else if (average2 > average1) {
			System.out.println("Average of second array is bigger ( " + average2 + " > " + average1 + " )");
		} else {
			System.out.println("Averages of arrays are equal ( " + average1 + " = " + average2 + " )");
		}

		scanner.close();
	}
}