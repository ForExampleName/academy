package by.academy.homeworks.homework_5;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class DifferentCollectionCompare {
	private static final int LIST_SIZE = 1_000_000;
	private static final int TIMES_TO_CHOOSE = 10_000;
	private static final Random random = new Random();

	private static void fillList(List<Integer> list) {
		for (int i = 0; i < LIST_SIZE; i++) {
			list.add(i);
		}
	}

	private static void doSomethingMillionTimes(List<Integer> list) {
		Integer temp = null;

		for (int i = 0; i < TIMES_TO_CHOOSE; i++) {
			temp = list.get(random.nextInt(LIST_SIZE));
		}
	}

	private static long calcFunctionTime(List<Integer> list) {
		long start = System.currentTimeMillis();
		doSomethingMillionTimes(list);
		return System.currentTimeMillis() - start;
	}

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>(LIST_SIZE);

		fillList(arrayList);

		List<Integer> linkedList = new LinkedList<>(arrayList);

		System.out.println("ArrayList. Time = " + calcFunctionTime(arrayList) / 1000.0 + " seconds");
		System.out.println("LinkedList. Time = " + calcFunctionTime(linkedList) / 1000.0 + " seconds");
	}
}