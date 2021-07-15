package by.academy.tasks.arrays;

import java.util.Arrays;
import java.util.Random;

public class Task8 {
	private static final int SIZE = 15;

	public static void main(String[] args) {
		Random random = new Random();

		int[] array = new int[SIZE];

		for (int i = 0; i < SIZE; i++) {
			array[i] = random.nextInt(10);
		}

		System.out.println(Arrays.toString(array));

		int count = 0;

		for (int val : array) {
			if (val != 0 && (val & 0x01) == 0) {
				++count;
			}
		}

		System.out.println(count);
	}
}
