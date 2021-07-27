package by.academy.tasks.arrays;

import java.util.Random;

public class Task18 {
	private static final Random random = new Random();

	public static void main(String[] args) {
		int[][] table = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				table[i][j] = (i + 1) * (j + 1);
			}
		}

		int firstValue;
		int secondValue;

		for (int i = 0; i < 15; i++) {
			while (true) {
				firstValue = random.nextInt(9) + 1;
				secondValue = random.nextInt(9) + 1;

				if (table[firstValue - 1][secondValue - 1] != 0) {
					System.out.println(firstValue + "*" + secondValue + "=" + table[firstValue - 1][secondValue - 1]);
					table[firstValue - 1][secondValue - 1] = 0;
					table[secondValue - 1][firstValue - 1] = 0;
					break;
				}
			}
		}
	}
}