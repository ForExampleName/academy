package by.academy.tasks.arrays;

import java.util.Random;

public class Task7 {
	private static final int SIZE = 12;

	public static void main(String[] args) {
		Random random = new Random();

		int[] array = new int[SIZE];

		float average = 0F;
		int sum = 0;

		for (int i = 0; i < SIZE; i++) {
			array[i] = random.nextInt(10);
		}

		for (int val : array) {
			sum += val;
		}

		average = sum / (float) SIZE;

		System.out.println(average);
	}
}
