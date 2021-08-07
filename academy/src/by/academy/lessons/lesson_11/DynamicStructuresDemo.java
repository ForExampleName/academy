package by.academy.lessons.lesson_11;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DynamicStructuresDemo {

	private static void printList(List<Box> arraylist) {
		for (Box b : arraylist) {
			System.out.println(b.toString());
		}
		System.out.println();
	}

	public static void main(String[] args) {
		List<Box> arraylist = new ArrayList<>();

		for (int i = 2; i <= 9; i++) {
			arraylist.add(new Box(i, i, i, i));
		}

		printList(arraylist);

		arraylist.get(0).setWeight(1);

		printList(arraylist);

		arraylist.remove(arraylist.size() - 1);

		printList(arraylist);

		System.out.println(Arrays.toString(arraylist.toArray()));
	}
}