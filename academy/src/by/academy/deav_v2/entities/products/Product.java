package by.academy.deav_v2.entities.products;

import java.util.Objects;
import java.util.List;

public abstract class Product implements Cloneable, Comparable<Product> {
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

	public abstract double calcDiscount();

	public double calcPrice() {
		return Math.round((1 - calcDiscount()) * price * quantity * 100.0) / 100.0;
	}

	private static int getProductIndexInList(Product toFind, List<Product> listOfProducts) {
		for (int i = 0; i < listOfProducts.size(); i++) {
			if (toFind.compareTo(listOfProducts.get(i)) == 0) {
				return i;
			}
		}

		return -1;
	}

	public static void addProductToList(Product newProduct, List<Product> listOfProducts) {
		int productIndex = getProductIndexInList(newProduct, listOfProducts);

		if (productIndex == -1) {
			listOfProducts.add(newProduct);
		} else {
			Product sameProduct = listOfProducts.get(productIndex);
			sameProduct.setQuantity(sameProduct.getQuantity() + newProduct.getQuantity());
		}
	}

	public static boolean removeProductFromList(Product toRemove, List<Product> listOfProducts) {
		int productIndex = getProductIndexInList(toRemove, listOfProducts);

		if (productIndex == -1) {
			return false;
		} else {
			Product foundProduct = listOfProducts.get(productIndex);
			if (foundProduct.getQuantity() == toRemove.getQuantity()) {
				listOfProducts.remove(productIndex);
			} else {
				foundProduct.setQuantity(foundProduct.getQuantity() - toRemove.getQuantity());
			}
		}

		return true;
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
	public int compareTo(Product o) {
		int result;

		result = name.compareTo(o.getName());
		if (result != 0)
			return result;

		result = Double.compare(price, o.getPrice());

		return result;
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