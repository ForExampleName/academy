package by.academy.homeworks.homework_3.deal;

import java.util.Objects;

public abstract class Product implements Cloneable{
	protected String name;
	protected double price;
	protected int quantity;

	public Product() {
		super();
	}

	public Product(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public double calcPrice() {
		return (1 - calcDiscount()) * price * quantity;
	}

	protected abstract double calcDiscount();

	public abstract String getDescription();

	public abstract String getBillDescription();

	public String getName() {
		return name;
	}

	public static void addProductToArray(Product[] array, Product newProduct) {
		for (Product p : array) {
			if (p.equals(newProduct)) {
				p.setQuantity(p.getQuantity() + newProduct.getQuantity());
				return;
			}
		}

		Product[] newArray = new Product[array.length + 1];

		System.arraycopy(array, 0, newArray, 0, array.length);

		newArray[array.length] = newProduct;
		array = newArray;
	}

	public static boolean removeProductFromArray(Product[] array, Product toRemove) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(toRemove)) {
				if (toRemove.getQuantity() > array[i].getQuantity()) {
					System.out.println("Ошибка. Попытка удалить слишком большое количество товара");
					return false;
				} else if (toRemove.getQuantity() < array[i].getQuantity()) {
					array[i].setQuantity(array[i].getQuantity() - toRemove.getQuantity());
					return true;
				} else if (toRemove.getQuantity() == array[i].getQuantity()) {
					Product[] newArray = new Product[array.length - 1];

					if (i != 0) {
						System.arraycopy(array, 0, newArray, 0, i);
					}
					System.arraycopy(array, i + 1, newArray, i, array.length - i);

					array = newArray;
					return true;
				}
			}
		}

		System.out.println("Ошибка. Данный продукт не найден");
		return false;

	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;

	}

	@Override
	public Product clone() throws CloneNotSupportedException{
        return (Product) super.clone();
    }
	
	@Override
	public int hashCode() {
		return Objects.hash(name, price, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);// && quantity ==
																							// other.quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}
}