package by.academy.lessons.lesson_9;

import java.io.Serializable;

public class Average<T extends Number & Serializable & Comparable<T>> {
	protected T[] items;

	public Average() {
		super();
	}

	public Average(T[] items) {
		this.items = items;
	}

	public T[] getItems() {
		return items;
	}

	public void setItems(T[] items) {
		this.items = items;
	}

	public Double average() {
		if (items.length == 0) {
			return 0.0;
		}

		double sum = 0;

		for (T item : items) {
			sum += item.doubleValue();
		}

		return sum / items.length;
	}

	// Используя <Т>, мы не позволяем сравнивать, например, Average<Integer> и
	// Average<Double>
	// Поскольку в объявлении класса мы указали ограничения для Т, то можно
	// использовать ?, не пугаясь,
	// что на вход метода придет параметризованный тип, который не сможет выполнять
	// какие-либо действия
	public boolean compare(Average<?> toCompare) {
		double toCompareAverage = toCompare.average();
		double thisAverage = average();

		return toCompareAverage == toCompareAverage;
	}

}