package by.academy.tasks.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task12 {
	private static final Random random = new Random();
	private static final Scanner scanner = new Scanner(System.in);

	private static boolean isValueSuit(int[] array, int value, int position) {
		if (value == 0) {
			return false;
		}

		if (position == 0) {
			return true;
		}

		if ((array[position - 1] < 0 && value < 0) || (array[position - 1] > 0 && value > 0)) {
			return false;
		}

		for (int i = 0; i < position; i++) {
			if (array[i] == value) {
				return false;
			}
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

		int arraySize;

		do {
			System.out.print("Enter array size: ");
			arraySize = scanner.nextInt();
		} while (arraySize <= 0);

		int[] array = new int[arraySize];

		int temp;

		int errorCounter = 0;
		boolean errorFlag = false;
		globalLoop: for (int i = 0; i < arraySize; i++) {
			while (true) {
				temp = random.nextInt(rightBorder - leftBorder + 1) + leftBorder;
				if (isValueSuit(array, temp, i)) {
					array[i] = temp;
					errorCounter = 0;
					break;
				}
				if (++errorCounter == 100) {
					System.out.println("Current combination of inputs can not create answer");
					errorFlag = true;
					break globalLoop;
				}

			}
		}

		if (!errorFlag) {
			System.out.println(Arrays.toString(array));
		}

		scanner.close();
	}
}