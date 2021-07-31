package by.academy.homeworks.homework_3.deal;

import java.util.Objects;

import by.academy.homeworks.homework_3.deal.enums.Color;

public class MobilePhone extends Product implements Cloneable{
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
	public String getDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(" ");
		builder.append(model);
		builder.append(" (");
		builder.append(color.getName());
		builder.append(") ");
		builder.append(camera);
		builder.append(" МП ");
		builder.append(price);
		builder.append(" Руб");
		builder.append(" x ");
		builder.append(quantity);
		return builder.toString();
	}

	@Override
	public String getBillDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(" ");
		builder.append(model);
		builder.append(" (");
		builder.append(color.getName());
		builder.append(") ");
		builder.append(camera);
		builder.append(" МП");
		builder.append(":\\n");
		builder.append(quantity);
		builder.append(" x ");
		builder.append(price);
		builder.append(" - ");
		builder.append(calcDiscount() * 100);
		builder.append("% = ");
		builder.append(calcPrice());
		builder.append(" Руб");
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
	public MobilePhone clone() throws CloneNotSupportedException{
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
//		System.out.println("PHONE");
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