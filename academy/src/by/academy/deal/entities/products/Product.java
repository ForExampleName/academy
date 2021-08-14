package by.academy.deal.entities.products;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public abstract class Product implements Cloneable {
	protected String name;
	protected double price;
	protected int quantity;

	public static final Comparator<Product> productComparator = new Comparator<Product>() {
		@Override
		public int compare(Product o1, Product o2) {
			return Double.compare(o1.getPrice(), o2.getPrice());
		}
	};

	public Product() {
		super();
	}

	public Product(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	protected abstract double calcDiscount();

	public abstract String getDescription();

	public abstract String getBillDescription();

	public abstract boolean compare(Product toCompare);

	public double calcPrice() {
		return Math.round((1 - calcDiscount()) * price * quantity * 100.0) / 100.0;
	}

	public static Product[] addProductToArray(Product[] array, Product newProduct) {
		if (array != null) {
			for (Product p : array) {
				if (p.compare(newProduct)) {
					p.setQuantity(p.getQuantity() + newProduct.getQuantity());
					return array;
				}
			}

			array = Arrays.copyOf(array, array.length + 1);
			array[array.length - 1] = newProduct;
		} else {
			array = new Product[1];
			array[0] = newProduct;
		}

		return array;
	}

	public static Product[] removeProductFromArray(Product[] array, Product toRemove) {
		if (array == null) {
			System.out.println("Ошибка. Массив пустой");
			return null;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i].compare(toRemove)) {
				if (toRemove.getQuantity() > array[i].getQuantity()) {
					System.out.println("Ошибка. Попытка удалить слишком большое количество товара");
					return array;
				} else if (toRemove.getQuantity() < array[i].getQuantity()) {
					array[i].setQuantity(array[i].getQuantity() - toRemove.getQuantity());
					return array;
				} else if (toRemove.getQuantity() == array[i].getQuantity()) {
					if (array.length == 1) {
						return null;
					}

					Product[] newArray = new Product[array.length - 1];

					if (i != 0) {
						System.arraycopy(array, 0, newArray, 0, i);
					}
					System.arraycopy(array, i + 1, newArray, i, array.length - i - 1);

					return newArray;
				}
			}
		}

		System.out.println("Ошибка. Данный продукт не найден");
		return array;
	}

	@Deprecated
	public void test() {
		int i = 0;

		// some hard logic
		while (i++ < 1_000_000) {
		}
	}

	public String getName() {
		return name;
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
	public Product clone() throws CloneNotSupportedException {
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
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity;
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