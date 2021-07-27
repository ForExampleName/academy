package by.academy.tasks.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task13 {
	private static final Random random = new Random();
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int arraySize;

		do {
			System.out.print("Enter number bigger than 3: ");
			arraySize = scanner.nextInt();
		} while (arraySize <= 3);

		int[] array = new int[arraySize];

		int evenItemsCount = 0;

		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(arraySize);
			if ((array[i] & 1) == 0 && array[i] != 0) {
				++evenItemsCount;
			}
		}

		System.out.println(Arrays.toString(array));

		if (evenItemsCount != 0) {
			int[] evenArray = new int[evenItemsCount];
			for (int i = 0, j = 0; i < array.length; i++) {
				if ((array[i] & 1) == 0 && array[i] != 0) {
					evenArray[j++] = array[i];
				}
			}
			System.out.println(Arrays.toString(evenArray));
		}

		scanner.close();
	}
}