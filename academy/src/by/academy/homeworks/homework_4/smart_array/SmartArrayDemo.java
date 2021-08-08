package by.academy.homeworks.homework_4.smart_array;

import java.util.Iterator;

public class SmartArrayDemo {
	private static void print(Iterator<Integer> iterator) {
		System.out.print("\nМассив: ");

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		SmartArray<Integer> sa = new SmartArray<>(3);
		Iterator<Integer> iterator = sa.iterator();

		sa.add(0);
		sa.add(1);
		sa.add(2);

		print(iterator);

		System.out.println("Элемент с индексом 1: " + sa.get(1));

		System.out.println("Первый элемент массива: " + sa.getFirst());
		System.out.println("Последний элемент массива: " + sa.getLast());

		sa.add(3);
		print(iterator);

		System.out.println("Размер массива = " + sa.capacity());
		System.out.println("Последний элемент на " + sa.getLastIndex() + " позиции");

		sa.remove(2);
		print(iterator);

		sa.remove(Integer.valueOf(3));
		print(iterator);
	}
}