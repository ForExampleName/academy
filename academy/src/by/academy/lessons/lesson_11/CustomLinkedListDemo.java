package by.academy.lessons.lesson_11;

import java.util.Iterator;

public class CustomLinkedListDemo {

	public static void main(String[] args) {
		CustomLinkedList<Integer> list = new CustomLinkedList<>();

		list.add(1);
		list.printList();

		list.remove(0);
		list.printList();

		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);

		list.printList();

		list.remove(0);
		list.printList();

		list.remove(4);
		list.printList();

		list.remove(3);

		list.printList();

		System.out.println();

		Iterator<Integer> iterator = list.iterator();

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
}