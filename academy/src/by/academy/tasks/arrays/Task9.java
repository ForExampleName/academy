package by.academy.tasks.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task9 {

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
		float[] array3 = new float[arraySize];
		
		
		

		for (int i = 0; i < arraySize; i++) {
			array1[i] = random.nextInt(rightBorder - leftBorder + 1) + leftBorder;
			array2[i] = random.nextInt(rightBorder - leftBorder + 1) + leftBorder;
			array3[i] = array1[i]/(float)array2[i];
		}

		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		System.out.println(Arrays.toString(array3));

		for(float value: array3) {
			if(value == (int)value)
				System.out.print(value + " ");
		}
		
		scanner.close();
	}
}