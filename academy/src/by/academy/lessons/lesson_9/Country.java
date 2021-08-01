package by.academy.lessons.lesson_9;

import java.io.Serializable;

public class Country<T extends CharSequence & Comparable<String>, V extends Number & Serializable, K extends Number> {
	protected T name;
	protected V area;
	protected K population;

	public Country() {
		super();
	}

	public Country(T name, V area, K population) {
		super();
		this.name = name;
		this.area = area;
		this.population = population;
	}

	public String showFieldTypes() {
		StringBuilder builder = new StringBuilder();

		builder.append("Name varible is ");
		if (name == null)
			builder.append("null");
		else
			builder.append(name.getClass().getName());

		builder.append("\nArea varible is ");
		if (area == null)
			builder.append("null");
		else
			builder.append(area.getClass().getName());

		builder.append("\nPopulation varible is ");
		if (population == null)
			builder.append("null");
		else
			builder.append(population.getClass().getName());

		return builder.toString();
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	public V getArea() {
		return area;
	}

	public void setArea(V area) {
		this.area = area;
	}

	public K getPopulation() {
		return population;
	}

	public void setPopulation(K population) {
		this.population = population;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Country [name=");
		builder.append(name);
		builder.append(", area=");
		builder.append(area);
		builder.append(", population=");
		builder.append(population);
		builder.append("]");
		return builder.toString();
	}
}