package by.academy.tasks.arrays;

import java.util.Arrays;

public class Task5 {
	private static final int MIN_POS = 0;
	private static final int MAX_POS = 1;

	private static final int INNER_ARRAY_COUNT = 5;

	/* Custom sorting function for second way*/
	private static void sort(int[] array) {
		int temp = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < (array.length - i); j++) {
				if (array[j - 1] > array[j]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] array = { 
				{ 2, 7, 3, 7, 2, 9, 4, 0 }, 
				{ 3, 8, 2, 1, 3, 2, 4, 23 }, 
				{ 4, 5, 23, 56, 74, 2, 123, -4 },
				{ -4, -6, -34, 654, 3, 5, 21, 0 }, 
				{ 3, 3, 3, 3, 3, 3, 3, 3 } 
		};

		int[][] minMaxArray = new int[5][2];

		/* First way */
		int min = 0;
		int max = 0;

		for (int i = 0; i < INNER_ARRAY_COUNT; i++) {

			min = array[i][0];
			max = array[i][0];

			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] < min) {
					min = array[i][j];
				}
				if (array[i][j] > max) {
					max = array[i][j];
				}
			}

			minMaxArray[i][MIN_POS] = min;
			minMaxArray[i][MAX_POS] = max;
		}

		/* Second way (with custom sort function) */
//		for (int i = 0; i < INNER_ARRAY_COUNT; i++) {
//			sort(array[i]);
//			minMaxArray[i][MIN_POS] = array[i][0];
//			minMaxArray[i][MAX_POS] = array[i][array[i].length - 1];
//		}

		/* Third method */
//		for (int i = 0; i < INNER_ARRAY_COUNT; i++) {
//			Arrays.sort(array[i]);
//			minMaxArray[i][MIN_POS] = array[i][0];
//			minMaxArray[i][MAX_POS] = array[i][array[i].length - 1];
//		}

		System.out.println(Arrays.deepToString(array));
		System.out.println(Arrays.deepToString(minMaxArray));
	}
}
