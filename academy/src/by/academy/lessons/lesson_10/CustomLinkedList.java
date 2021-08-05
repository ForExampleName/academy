package by.academy.lessons.lesson_10;

public class CustomLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private Integer size = 0;

	public void add() {

	}

	public void remove() {

	}

	public T get(int index) {
		return null;
	}

	public void set(int index, T item) {

	}

	class Node<T> {
		T value;
		Node<T> next;
		Node<T> prev;

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [value=");
			builder.append(value);
			builder.append(", next=");
			builder.append(next);
			builder.append(", prev=");
			builder.append(prev);
			builder.append("]");
			return builder.toString();
		}
	}
}