package by.academy.deav_v2.entities.products;

import java.util.Objects;

import by.academy.deal.annotations.ProductProvider;
import by.academy.deav_v2.enums.Resolution;


@ProductProvider(country = "Taiwan", shelfLife = 6, parts = { "Screen", "Speakers" })
public class TV extends Product implements Cloneable, Comparable<Product> {
	protected String model;
	protected float diagonal;
	protected Resolution resolution;

	public TV() {
		super();
	}

	public TV(String name, double price, int quantity, String model, float diagonal, Resolution resolution) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.model = model;
		this.diagonal = diagonal;
		this.resolution = resolution;
	}

	@Override
	public double calcDiscount() {
		if (diagonal >= 40) {
			if (resolution.equals(Resolution.UHD))
				return 0.08;
			return 0.05;
		}
		return 0;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(float diagonal) {
		this.diagonal = diagonal;
	}

	public Resolution getResolution() {
		return resolution;
	}

	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}

	@Override
	public TV clone() throws CloneNotSupportedException {
		return (TV) super.clone();
	}

	@Override
	public int compareTo(Product o) {
		int result = -1;

		if (!(o instanceof TV))
			return result;

		result = super.compareTo(o);
		if (result != 0)
			return result;

		TV anotherTV = (TV) o;

		result = model.compareTo(anotherTV.getModel());
		if (result != 0)
			return result;

		result = Float.compare(diagonal, anotherTV.getDiagonal());
		if (result != 0)
			return result;

		result = resolution.compareTo(anotherTV.getResolution());

		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(diagonal, model, resolution);
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
		TV other = (TV) obj;
		return Float.floatToIntBits(diagonal) == Float.floatToIntBits(other.diagonal)
				&& Objects.equals(model, other.model) && resolution == other.resolution;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TV [model=");
		builder.append(model);
		builder.append(", diagonal=");
		builder.append(diagonal);
		builder.append(", resolution=");
		builder.append(resolution);
		builder.append("]");
		return builder.toString();
	}
}