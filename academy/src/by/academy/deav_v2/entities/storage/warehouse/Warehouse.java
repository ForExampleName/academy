package by.academy.deav_v2.entities.storage.warehouse;

import java.util.List;
import java.util.Objects;
import by.academy.deav_v2.entities.products.Laptop;
import by.academy.deav_v2.entities.products.MobilePhone;
import by.academy.deav_v2.entities.products.Product;
import by.academy.deav_v2.entities.products.TV;
import by.academy.deav_v2.enums.Color;
import by.academy.deav_v2.enums.Resolution;

public final class Warehouse {
	private List<Product> catalog;

	public Warehouse() {
		super();
		catalog.add(new MobilePhone("Samsung", 1800.0D, 2, "Galaxy S20", Color.BLACK, 12.0F));
		catalog.add(new MobilePhone("Samsung", 3700.0D, 1, "Galaxy S21", Color.WHITE, 108.0F));
		catalog.add(new MobilePhone("Apple", 2900.0D, 1, "iPhone 12 Pro", Color.BLUE, 12.0F));
		catalog.add(new TV("Samsung", 2200.0D, 3, "QE55Q77TAU", 55.0F, Resolution.UHD));
		catalog.add(new TV("LG", 1900.0D, 3, "55UP78006LC", 55.0F, Resolution.UHD));
		catalog.add(new Laptop("ASUS", 2600.0D, 2, "ROG Strix G15", 2900, 16));
		catalog.add(new Laptop("Apple", 2900.0D, 1, "Macbook Air 13", 2900, 8));
	}

	public Warehouse(List<Product> catalog) {
		super();
		this.catalog = catalog;
	}

	public void addProduct(Product product) {
		Product.addProductToList(product, catalog);
	}

	public void addProducts(List<Product> products) {
		for (Product p : products) {
			Product.addProductToList(p, catalog);
		}
	}

	public boolean pickProduct(Product product) {
		if (!Product.removeProductFromList(product, catalog)) {
			System.out.println("На складе не найден данный продукт");
			return false;
		}

		return true;
	}

	public boolean isEmpty() {
		return catalog.isEmpty();
	}

	public List<Product> getCatalog() {
		return catalog;
	}

	public void setCatalog(List<Product> catalog) {
		this.catalog = catalog;
	}

	@Override
	public int hashCode() {
		return Objects.hash(catalog);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warehouse other = (Warehouse) obj;
		return Objects.equals(catalog, other.catalog);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Warehouse [catalog=");
		builder.append(catalog);
		builder.append("]");
		return builder.toString();
	};
}