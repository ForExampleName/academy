package by.academy.homeworks.homework_3.deal;

import java.util.Objects;

public class Laptop extends Product implements Cloneable {
	protected String model;
	protected int processor;
	protected int ram;

	public Laptop() {
		super();
	}

	public Laptop(String name, double price, int quantity, String model, int processor, int ram) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.model = model;
		this.processor = processor;
		this.ram = ram;
	}

	@Override
	protected double calcDiscount() {
		if (processor > 2.5) {
			if (ram > 16)
				return 0.08;
			return 0.05;
		}
		if (ram > 16)
			return 0.025;
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
		Laptop otherLaptop = (Laptop) toCompare;
		return Objects.equals(name, otherLaptop.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(otherLaptop.price)
				&& Objects.equals(model, otherLaptop.model) && processor == otherLaptop.processor
				&& ram == otherLaptop.ram;
	}

	@Override
	public String getDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ноутбук ");
		builder.append(name);
		builder.append(" ");
		builder.append(model);
		builder.append(" (");
		builder.append("частота процессора ");
		builder.append(processor);
		builder.append(" МГц, ");
		builder.append("ОЗУ ");
		builder.append(ram);
		builder.append(" ГБ");
		builder.append(") ");
		builder.append(price);
		builder.append(" руб");
		builder.append(" x ");
		builder.append(quantity);
		return builder.toString();
	}

	@Override
	public String getBillDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ноутбук ");
		builder.append(name);
		builder.append(" ");
		builder.append(model);
		builder.append(" (");
		builder.append("частота процессора ");
		builder.append(processor);
		builder.append(" МГц, ");
		builder.append("ОЗУ ");
		builder.append(ram);
		builder.append(" ГБ");
		builder.append(") ");
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

	public int getProcessor() {
		return processor;
	}

	public void setProcessor(int processor) {
		this.processor = processor;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	@Override
	public Laptop clone() throws CloneNotSupportedException {
		return (Laptop) super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(model, processor, ram);
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
		Laptop other = (Laptop) obj;
		return Objects.equals(model, other.model) && processor == other.processor && ram == other.ram;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Laptop [model=");
		builder.append(model);
		builder.append(", processor=");
		builder.append(processor);
		builder.append(", ram=");
		builder.append(ram);
		builder.append("]");
		return builder.toString();
	}
}