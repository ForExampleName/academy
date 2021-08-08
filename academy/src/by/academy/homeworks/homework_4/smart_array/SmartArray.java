package by.academy.homeworks.homework_4.smart_array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SmartArray<T> implements Iterable<T> {
	private T[] array;
	private Integer size = 0;

	@SuppressWarnings("unchecked")
	public SmartArray() {
		super();
		array = (T[]) new Object[16]; // size = 0 automatically
	}

	@SuppressWarnings("unchecked")
	public SmartArray(int capacity) {
		super();
		array = (T[]) new Object[capacity]; // size = 0 automatically
	}

	public SmartArray(T[] array) {
		super();
		this.array = array;
		size = array.length; // we consider that array is not empty and is full of items
	}

	public void add(T item) {
		if (size == array.length) {
			expandArray();
		}

		array[size++] = item;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			System.out.println("Index out of bounds");
			return null;
		}

		return array[index];
	}

	public T getFirst() {
		if (size == 0) {
			return null;
		}

		return array[0];
	}

	public T getLast() {
		if (size == 0) {
			return null;
		}

		return array[size - 1];
	}

	public Integer capacity() {
		return array.length;
	}

	public Integer getLastIndex() {
		if (size == 0) {
			return null;
		}

		return size - 1;
	}

	public void remove(int index) {
		if (index < 0 || index >= size) {
			System.out.println("Index out of bounds");
			return;
		}

		if (index < size - 1)
			System.arraycopy(array, index + 1, array, index, size - index - 1);

		array[--size] = null;
	}

	public void remove(T item) {
		if (size == 0) {
			System.out.println("Array is empty");
			return;
		}

		for (int i = 0; i < size; i++) {
			if (item.equals(array[i])) {
				remove(i);
				return;
			}
		}

		System.out.println("Item not found");
	}

	public void expandArray() {
		array = Arrays.copyOf(array, (array.length == 0) ? 1 : array.length * 2);
	}

	@Override
	public Iterator<T> iterator() {
		return new CustomIterator();
	}

	private class CustomIterator implements Iterator<T> {
		int index;

		@Override
		public boolean hasNext() {

			if (size == 0) {
				return false;
			}

			if (index < size) {
				return array[index] != null;
			}

			index = 0;
			return false;
		}

		@Override
		public T next() {
			return array[index++];
		}

		@SuppressWarnings("rawtypes")
		private SmartArray getEnclosingInstance() {
			return SmartArray.this;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(index);
			return result;
		}

		@Override
		@SuppressWarnings("unchecked")
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CustomIterator other = (CustomIterator) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return index == other.index;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("CustomIterator [index=");
			builder.append(index);
			builder.append("]");
			return builder.toString();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(array);
		result = prime * result + Objects.hash(size);
		return result;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SmartArray other = (SmartArray) obj;
		return Arrays.deepEquals(array, other.array) && Objects.equals(size, other.size);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SmartArray [array=");
		builder.append(Arrays.toString(array));
		builder.append(", size=");
		builder.append(size);
		builder.append("]");
		return builder.toString();
	}
}