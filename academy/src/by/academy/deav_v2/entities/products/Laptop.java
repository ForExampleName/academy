package by.academy.deav_v2.entities.products;

import java.util.Objects;

import by.academy.deal.annotations.ProductProvider;

@ProductProvider(parts = { "CPU", "RAM", "GPU", "Motherboard" })
public class Laptop extends Product implements Cloneable, Comparable<Product> {
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
	public double calcDiscount() {
		if (processor > 2.5) {
			if (ram > 16)
				return 0.08;
			return 0.05;
		}
		if (ram > 16)
			return 0.025;
		return 0;
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
	public int compareTo(Product o) {
		int result = -1;

		if (!(o instanceof Laptop))
			return result;

		result = super.compareTo(o);
		if (result != 0)
			return result;

		Laptop anotherLaptop = (Laptop) o;

		result = model.compareTo(anotherLaptop.getModel());
		if (result != 0)
			return result;

		result = processor - anotherLaptop.getProcessor();
		if (result != 0)
			return result;

		result = ram - anotherLaptop.getRam();

		return result;
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