package by.academy.lessons.lesson_11;

import java.util.Iterator;

// Linked  list

//         head              tail
//			 |                 |
//			 V                 V
//	      |Next |->|Next |->|Next |->null
//	      |_____|  |_____|  |_____|
//	null<-|Prev |<-|Prev |<-|Prev |
//	      |_____|  |_____|  |_____|
//	      |Value|  |Value|  |Value|

@SuppressWarnings("unused")
public class CustomLinkedList<T> implements Iterable<T> {

	private Node<T> head;
	private Node<T> tail;
	private Integer size = 0;

	public void add(T value) {
		Node<T> newNode = new Node<>();
		newNode.value = value;

		if (tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}

		++size;
	}

	public void remove(int index) {
		if (index < 0 || index >= size) {
			System.out.println("Index out of bounds");
			return;
		}

		if (size == 1) {
			head = null;
			tail = null;

			size = 0;
			return;
		}

		if (index == size - 1) {
			Node<T> prevNode = tail.prev;
			prevNode.next = null;

			tail = prevNode;

			--size;
			return;
		}

		// if we delete head and list consist of more than 1 element
		if (index == 0) {
			Node<T> nextNode = head.next;
			nextNode.prev = null;

			head = nextNode;

			--size;
			return;
		}

		Node<T> currentNode = head;

		for (int i = 0; currentNode != null; i++) {
			if (i == index) {

				Node<T> nextNode = currentNode.next;
				Node<T> prevNode = currentNode.prev;

				prevNode.next = nextNode;
				nextNode.prev = prevNode;

				--size;
				return;
			}
			currentNode = currentNode.next;
		}
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			System.out.println("Index out of bounds");
			return null;
		}

		Node<T> currentNode = head;
		T value = null;

		for (int i = 0; currentNode != null; i++) {
			if (i == index) {
				value = currentNode.value;
				break;
			}
			currentNode = currentNode.next;
		}
		return value;
	}

	public Node<T> getNode(int index) {
		if (index < 0 || index >= size) {
			System.out.println("Index out of bounds");
			return null;
		}

		Node<T> currentNode = head;

		for (int i = 0; currentNode != null; i++) {
			if (i == index) {
				break;
			}
			currentNode = currentNode.next;
		}

		return currentNode;
	}

	public T getHeadValue() {
		if (head == null) {
			return null;
		}

		return head.value;
	}

	public T getTailValue() {
		if (tail == null) {
			return null;
		}

		return tail.value;
	}

	public void set(int index, T item) {
		if (index < 0 || index >= size) {
			System.out.println("Index out of bounds");
			return;
		}

		Node<T> currentNode = head;

		for (int i = 0; currentNode != null; i++) {
			if (i == index) {
				currentNode.value = item;
				return;
			}
			currentNode = currentNode.next;
		}
	}

	public void printList() {
		if (size == 0) {
			System.out.println("List is empty");
			return;
		}

		Node<T> currentNode = head;

		while (currentNode != null) {
			System.out.print(currentNode.value + " ");
			currentNode = currentNode.next;
		}

		System.out.println();
	}

	@SuppressWarnings("hiding")
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

	@Override
	public Iterator<T> iterator() {
		return new InnerIterator();
	}

	class InnerIterator implements Iterator<T> {
		Node<T> current = null;

		@Override
		public boolean hasNext() {
			if (current == null) {
				return head != null;
			}

			return current.next != null;
		}

		@Override
		public T next() {
			if (current == null) {
				current = head;
			}

			T value = current.value;
			current = current.next;

			return null;
		}
	}
}