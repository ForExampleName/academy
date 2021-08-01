package by.academy.lessons.lesson_9;

public class SmartArrayDemo {

	public static void main(String[] args) {
		Double[] array1 = { 3.0, 18.0, 35.23, 35.24, 30.0 };
		Integer[] array2 = { 32, 85, 93, 92, 101 };

		SmartArray<Double> smartDoubleArray = new SmartArray<>(array1);
		SmartArray<Integer> smartIntegerArray = new SmartArray<>(array2);

		System.out.println(smartDoubleArray.min());
		System.out.println(smartDoubleArray.max());
		System.out.println(smartIntegerArray.min());
		System.out.println(smartIntegerArray.max());
	}
}