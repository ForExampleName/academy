package by.academy.homeworks.homework_5;

import java.util.Arrays;
import java.util.Iterator;

public class TwoDimArray<T> implements Iterable<T> {
	T[][] array;

	public TwoDimArray() {
		super();
	}

	public TwoDimArray(T[][] array) {
		super();
		this.array = array;
	}

	public T[][] getArray() {
		return array;
	}

	public void setArray(T[][] array) {
		this.array = array;
	}

	@Override
	public Iterator<T> iterator() {
		return new TwoDimIterator();
	}

	private class TwoDimIterator implements Iterator<T> {
		int indexY;
		int indexX;

		@Override
		public boolean hasNext() {
			if (array.length == 0) {
				return false;
			}

			if (indexY < array.length && indexX < array[indexY].length) {
				return true;
			}

			indexY = 0;
			indexX = 0;

			return false;
		}

		@Override
		public T next() {
			T next = array[indexY][indexX++];

			if (indexX == array[indexY].length) {
				++indexY;
				indexX = 0;
			}

			return next;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(array);
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwoDimArray other = (TwoDimArray) obj;
		return Arrays.deepEquals(array, other.array);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TwoDimArray [array=");
		builder.append(Arrays.toString(array));
		builder.append("]");
		return builder.toString();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String... args) {
		Integer[][] array = { { 1, 4, 6 }, { 8, 9, 2, 3, 5 }, { 1, 10 }, {} };

		TwoDimArray twoDimArray = new TwoDimArray(array);
		Iterator<Integer> iterator = twoDimArray.iterator();

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
}