package by.academy.lessons.lesson_10;

import java.util.Arrays;

public class CustomArrayList<T> {
	protected T[] list;
	protected int size;

	@SuppressWarnings("unchecked")
	public CustomArrayList() {
		super();
		list = (T[]) new Object[10];
	}

	@SuppressWarnings("unchecked")
	public CustomArrayList(int initCapacity) {
		super();
		list = (T[]) new Object[initCapacity];
	}

	public CustomArrayList(T[] list) {
		super();
		this.list = list;
		size = list.length;
	}

	public void add(T item) {
		if (size == list.length) {
			resizeList();
		}

		list[size++] = item;
	}

	public void remove(T item) {
		for (int i = 0; i < size; i++) {
			if (list[i].equals(item)) {
				remove(i);
				return;
			}
		}
	}

	public void remove(int index) {
		if (index < 0 || index >= size) {
			System.out.println("IndexOutOfBounds");

			return;
		}

		if (index < size - 1)
			System.arraycopy(list, index + 1, list, index, size - index - 1);

		list[--size] = null;

		return;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			System.out.println("IndexOutOfBounds");

			return null;
		}

		return list[index];
	}

	public void set(int index, T item) {
		if (index < 0 || index > size) {
			System.out.println("IndexOutOfBounds");

			return;
		}

		if (index == size) {
			list[size++] = item;
		} else {
			list[index] = item;
		}
	}

	public T[] getList() {
		return list;
	}

	@SuppressWarnings("unchecked")
	private void resizeList() {
		T[] resizedList = (T[]) new Object[list.length * 2 + 1];

		System.arraycopy(list, 0, resizedList, 0, list.length);

		list = resizedList;
	}

}