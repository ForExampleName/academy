package by.academy.deal.entities.products;

import java.util.Objects;

import by.academy.deal.annotations.ProductProvider;
import by.academy.deal.enums.Color;

@ProductProvider(shelfLife = 24, parts = { "Screen", "Memory", "Camera" })
public class MobilePhone extends Product implements Cloneable {
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
	protected double calcDiscount() {
		if (camera >= 20) {
			return 0.05;
		}
		return 0;
	}

	@Override
	public boolean compare(Product toCompare) {
		if (this == toCompare)
			return true;
		if (toCompare == null)
			return false;
		if (getClass() != toCompare.getClass())
			return false;
		MobilePhone otherPhone = (MobilePhone) toCompare;
		return Objects.equals(name, otherPhone.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(otherPhone.price)
				&& Float.floatToIntBits(camera) == Float.floatToIntBits(otherPhone.camera) && color == otherPhone.color
				&& Objects.equals(model, otherPhone.model);
	}

	@Override
	public String getDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append("Мобильный телефон ");
		builder.append(name);
		builder.append(" ");
		builder.append(model);
		builder.append(" (");
		builder.append(color.getName());
		builder.append(") ");
		builder.append(camera);
		builder.append(" МП ");
		builder.append(price);
		builder.append(" руб");
		builder.append(" x ");
		builder.append(quantity);
		return builder.toString();
	}

	@Override
	public String getBillDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append("Мобильный телефон ");
		builder.append(name);
		builder.append(" ");
		builder.append(model);
		builder.append(" (");
		builder.append(color.getName());
		builder.append(") ");
		builder.append(camera);
		builder.append(" МП ");
		builder.append("| ");
		builder.append(quantity);
		builder.append(" x ");
		builder.append(price);
		builder.append(" - ");
		builder.append(Math.round(calcDiscount() * 10000) / 100.0);
		builder.append("% = ");
		builder.append(calcPrice());
		builder.append(" руб");
		return builder.toString();
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