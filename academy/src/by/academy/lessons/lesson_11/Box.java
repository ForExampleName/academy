package by.academy.lessons.lesson_11;

import java.util.Objects;

public class Box {
	int weight;
	int height;
	int width;
	int length;

	public Box() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Box(int weight, int height, int width, int length) {
		super();
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		return Objects.hash(height, length, weight, width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Box other = (Box) obj;
		return height == other.height && length == other.length && weight == other.weight && width == other.width;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Box [weight=");
		builder.append(weight);
		builder.append(", height=");
		builder.append(height);
		builder.append(", width=");
		builder.append(width);
		builder.append(", length=");
		builder.append(length);
		builder.append("]");
		return builder.toString();
	}
}