package by.academy.tasks.arrays_basics;

import java.util.Arrays;
import java.util.Random;

public class Task0 {
	private static final int SIZE = 12;

	public static void main(String[] args) {
		Random random = new Random();

		int[] array = new int[SIZE];

		float average = 0F;
		int sum = 0;

		for (int i = 0; i < SIZE; i++) {
			array[i] = random.nextInt(10);
			sum += array[i];
		}

		average = sum / (float) SIZE;
		
		for (int val : array) {
			if (val < average)
				System.out.print(val + " ");
		}
	}
}