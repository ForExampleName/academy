package by.academy.tasks.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task10 {
	private static final Random random = new Random();
	private static final Scanner scanner = new Scanner(System.in);

	private static void sort(int[] array) {
		if (array.length == 1)
			return;

		int minIdx;
		int temp;

		for (int i = 0; i < array.length; i++) {
			minIdx = i;

			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIdx]) {
					minIdx = j;
				}
			}

			if (minIdx == i)
				continue;

			temp = array[i];
			array[i] = array[minIdx];
			array[minIdx] = temp;
		}
	}

	private static boolean isFrequencyRepeat(int[] frequencies, int indexForCheck) {
		for (int i = 0; i < indexForCheck; i++) {
			if (frequencies[i] == frequencies[indexForCheck])
				return true;
		}
		return false;
	}

	private static int findMostFrequent(int[] array) {
		if (array.length == 1) {
			return array[0];
		}

		sort(array);

		int differentFrequenciesCount = 1;
		int currentValue = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i] != currentValue) {
				++differentFrequenciesCount;
				currentValue = array[i];
			}
		}

		if (differentFrequenciesCount == 1) {
			return currentValue;
		}

		int[] frequencies = new int[differentFrequenciesCount];
		for (int i = 0; i < frequencies.length; i++) {
			frequencies[i] = 1;
		}

		int currentFrequencyIndex = 0;

		int maxFrequencyValue = 1;

		int mostFrequentArrayItem = array[0];
		currentValue = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i] == currentValue) {
				++(frequencies[currentFrequencyIndex]);

				if (i == array.length - 1) {
					if (frequencies[currentFrequencyIndex] > maxFrequencyValue) {
						maxFrequencyValue = frequencies[currentFrequencyIndex];
						mostFrequentArrayItem = currentValue;
					}
					if (isFrequencyRepeat(frequencies, currentFrequencyIndex)) {
						return -1;
					}
				}
			} else {
				if (frequencies[currentFrequencyIndex] > maxFrequencyValue) {
					maxFrequencyValue = frequencies[currentFrequencyIndex];
					mostFrequentArrayItem = currentValue;
				}

				if (isFrequencyRepeat(frequencies, currentFrequencyIndex)) {
					return -1;
				}

				currentValue = array[i];
				++currentFrequencyIndex;

				// if last element in sorted array is differ, it's must be checked here,
				// because there is no more iterations and it's can not be checked for similar
				// frequency
				if (i == array.length - 1) {
					if (isFrequencyRepeat(frequencies, currentFrequencyIndex)) {
						return -1;
					}
				}
			}
		}

		return mostFrequentArrayItem;
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

		int mostFrequent = findMostFrequent(array);

		if (mostFrequent != -1)
			System.out.println("The most frequent number is " + mostFrequent);
		else
			System.out.println("Error. Same frequency of number is found inside array");

		scanner.close();
	}
}