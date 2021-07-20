package by.academy.tasks.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task10 {
	private static void sort(int[] array) {
		if (array.length == 1)
			return;

		int minIdx;
		int temp;
		
		for (int i = 0; i < array.length; i++) {
			minIdx = i;
			
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[minIdx]) {
					minIdx = j;
				}
			}
			
			if(minIdx == i)
				continue;
			
			temp = array[minIdx];
			
			System.arraycopy(array, i, array, i+1, minIdx-i);
			
			array[i] = temp;
		}
	}
	
	

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

		for (int i = 0; i < arraySize; i++) {
			array[i] = random.nextInt(rightBorder - leftBorder + 1) + leftBorder;
		}

		System.out.println(Arrays.toString(array));

		sort(array);
		
		System.out.print(Arrays.toString(array));
		
		scanner.close();
	}
}