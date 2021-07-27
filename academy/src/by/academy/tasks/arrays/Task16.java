package by.academy.tasks.arrays;

import java.util.Random;
import java.util.Scanner;

public class Task16 {
	private static final Random random = new Random();
	private static final Scanner scanner = new Scanner(System.in);

	private static void printTwoDimensionalArray(int[][] array, int outSize, int inSize) {
		System.out.print("[");
		for (int i = 0; i < outSize; i++) {
			if (i == 0)
				System.out.print("[");
			else
				System.out.print(" [");
			for (int j = 0; j < inSize; j++) {
				System.out.print(array[i][j] + ((j == (inSize - 1)) ? "" : " "));
			}
			System.out.print("]" + ((i == (outSize - 1)) ? "" : ",\n"));
		}
		System.out.println("]");
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

		int outsideArraySize;

		do {
			System.out.print("Enter outside array size: ");
			outsideArraySize = scanner.nextInt();
		} while (outsideArraySize <= 0);

		int insideArraySize;

		do {
			System.out.print("Enter inside array size: ");
			insideArraySize = scanner.nextInt();
		} while (insideArraySize <= 0);

		int[][] array = new int[outsideArraySize][insideArraySize];

		for (int i = 0; i < outsideArraySize; i++) {
			for (int j = 0; j < insideArraySize; j++) {
				array[i][j] = random.nextInt(rightBorder - leftBorder + 1) + leftBorder;
			}
		}

		printTwoDimensionalArray(array, outsideArraySize, insideArraySize);

		int maxMultResult = 0;
		int curMultResult = 1;
		int maxMultIndex = 0;

		for (int i = 0; i < outsideArraySize; i++) {
			for (int j = 0; j < insideArraySize; j++) {
				curMultResult *= array[i][j];
			}
			curMultResult = (curMultResult > 0) ? curMultResult : -curMultResult;

			if (curMultResult > maxMultResult) {
				maxMultResult = curMultResult;
				maxMultIndex = i;
			}

			curMultResult = 1;
		}

		System.out.println("Inside array string number " + maxMultIndex 
				+ " has max multiplication (" + maxMultResult + ")");

		scanner.close();
	}
}