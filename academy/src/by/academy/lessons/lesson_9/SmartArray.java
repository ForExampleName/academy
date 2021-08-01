package by.academy.lessons.lesson_9;

public class SmartArray<T extends Number> {
	protected T[] array;

	public SmartArray() {
		super();
	}

	public SmartArray(T[] array) {
		super();
		this.array = array;
	}

	public T[] getArray() {
		return array;
	}

	public void setArray(T[] array) {
		this.array = array;
	}

	public T min() {
		if (array.length == 0)
			return null;

		T min = array[0];

		if (array.length == 1)
			return min;

		for (T item : array) {
			if (item.doubleValue() < min.doubleValue()) {
				min = item;
			}
		}
		return min;
	}

	public T max() {
		if (array.length == 0)
			return null;

		T max = array[0];

		if (array.length == 1)
			return max;

		for (T item : array) {
			if (item.doubleValue() > max.doubleValue()) {
				max = item;
			}
		}
		return max;
	}

}