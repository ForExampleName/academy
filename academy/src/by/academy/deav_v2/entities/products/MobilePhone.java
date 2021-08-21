package by.academy.deav_v2.entities.products;

import java.util.Objects;

import by.academy.deal.annotations.ProductProvider;
import by.academy.deav_v2.enums.Color;

@ProductProvider(shelfLife = 24, parts = { "Screen", "Memory", "Camera" })
public class MobilePhone extends Product implements Cloneable, Comparable<Product> {
	protected String model;
	protected Color color;
	protected float camera;

	public MobilePhone() {
		super();
	}

	public MobilePhone(String name, double price, int quantity, String model, Color color, float camera) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.model = model;
		this.color = color;
		this.camera = camera;
	}

	@Override
	public double calcDiscount() {
		if (camera >= 20) {
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public float getCamera() {
		return camera;
	}

	public void setCamera(float camera) {
		this.camera = camera;
	}

	@Override
	public int compareTo(Product o) {
		int result = -1;

		if (!(o instanceof MobilePhone))
			return result;

		result = super.compareTo(o);
		if (result != 0)
			return result;

		MobilePhone anotherPhone = (MobilePhone) o;

		result = model.compareTo(anotherPhone.getModel());
		if (result != 0)
			return result;

		result = color.compareTo(anotherPhone.getColor());
		if (result != 0)
			return result;

		result = Float.compare(camera, anotherPhone.getCamera());

		return result;
	}

	@Override
	public MobilePhone clone() throws CloneNotSupportedException {
		return (MobilePhone) super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(camera, color, model);
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
		MobilePhone other = (MobilePhone) obj;
		return Float.floatToIntBits(camera) == Float.floatToIntBits(other.camera) && color == other.color
				&& Objects.equals(model, other.model);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobilePhone [model=");
		builder.append(model);
		builder.append(", color=");
		builder.append(color);
		builder.append(", camera=");
		builder.append(camera);
		builder.append("]");
		return builder.toString();
	}
}