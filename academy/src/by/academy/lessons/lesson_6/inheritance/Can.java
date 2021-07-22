package by.academy.lessons.lesson_6.inheritance;

import java.util.Objects;
import java.util.Random;

import by.academy.lessons.lesson_5.product.Product;

public class Can extends Product {
	private float weight;
	private float volume;

	public Can() {
		super();
	}

	public Can(String name, double price, int quantity) {
		super(name, price, quantity);
	}

	public Can(float weight, float volume) {
		super();
		this.weight = weight;
		this.volume = volume;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public int calculateSecretStuff(int border) {
		Random random = new Random();
		return random.nextInt(border);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Can [weight=");
		builder.append(weight);
		builder.append(", volume=");
		builder.append(volume);
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
		result = prime * result + Objects.hash(volume, weight);
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
		Can other = (Can) obj;
		return Float.floatToIntBits(volume) == Float.floatToIntBits(other.volume)
				&& Float.floatToIntBits(weight) == Float.floatToIntBits(other.weight);
	}
}
