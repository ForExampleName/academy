package by.academy.lessons.lesson_10;

import java.util.Arrays;

public class CustomArrayListDemo {

	public static void main(String[] args) {
		Integer[] testArray = { 0, 1, 2 };

		CustomArrayList<Integer> arrayList = new CustomArrayList<>(testArray);

		System.out.println(Arrays.toString(arrayList.getList()));

		arrayList.add(3);

		System.out.println(Arrays.toString(arrayList.getList()));
		
		arrayList.add(4);
		
		System.out.println(Arrays.toString(arrayList.getList()));
		
		arrayList.remove(4);
		
		System.out.println(Arrays.toString(arrayList.getList()));
	}
}