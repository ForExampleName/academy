package by.academy.homeworks.homework_3.deal;

import java.util.Objects;

import by.academy.homeworks.homework_3.deal.enums.Resolution;

public class TV extends Product implements Cloneable{
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
	protected double calcDiscount() {
		if (diagonal >= 40) {
			if (resolution.equals(Resolution.UHD))
				return 0.08;
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
		builder.append("диагональ ");
		builder.append(diagonal);
		builder.append(" дюйма(-ов), ");
		builder.append("разрешение ");
		builder.append(resolution.getName());
		builder.append(") ");
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
		builder.append("диагональ ");
		builder.append(diagonal);
		builder.append(" дюйма(-ов), ");
		builder.append("разрешение ");
		builder.append(resolution.getName());
		builder.append(") ");
		builder.append(":\n ");
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
	public TV clone() throws CloneNotSupportedException{
        return (TV) super.clone();
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
//		System.out.println("TV");
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