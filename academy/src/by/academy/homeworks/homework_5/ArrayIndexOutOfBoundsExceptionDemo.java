package by.academy.homeworks.homework_5;

public class ArrayIndexOutOfBoundsExceptionDemo {

	public static void main(String[] args) {
		int[] array = new int[8];

		try {
			for (int i = 0; i < 10; i++) {
				array[i] = i;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array is to small, expand the array");
		}
	}
}
