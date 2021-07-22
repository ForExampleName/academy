package by.academy.lessons.lesson_6.inheritance;

import java.util.Objects;
import java.util.Random;

import by.academy.lessons.lesson_5.product.Product;

public class Tube extends Product {
	private float diameter;
	private float length;

	public Tube() {
		super();
	}

	public Tube(String name, double price, int quantity) {
		super(name, price, quantity);
	}

	public Tube(float diameter, float length) {
		super();
		this.diameter = diameter;
		this.length = length;
	}

	public float getDiameter() {
		return diameter;
	}

	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public int getSomeMysteryValue(int border) {
		Random random = new Random();
		return random.nextInt(border);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tube [diameter=");
		builder.append(diameter);
		builder.append(", length=");
		builder.append(length);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(diameter, length);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tube other = (Tube) obj;
		return Float.floatToIntBits(diameter) == Float.floatToIntBits(other.diameter)
				&& Float.floatToIntBits(length) == Float.floatToIntBits(other.length);
	}
}