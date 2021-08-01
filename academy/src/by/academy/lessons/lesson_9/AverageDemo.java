package by.academy.lessons.lesson_9;

public class AverageDemo {

	public static void main(String[] args) {
		Double[] array1 = {1.0, 2.0, 3.0, 4.0, 5.0};
		Integer[] array2 = {1, 2, 3, 4, 5};
		
		Average<Double> average1 = new Average<>(array1);
		Average<Integer> average2 = new Average<>(array2);
		
		System.out.println(average1.average());
		System.out.println(average2.average());
	}
}