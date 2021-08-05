package by.academy.deal;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

import by.academy.deal.entities.products.Product;

public class Deal {
	protected Product[] products;
	protected User seller;
	protected User customer;
	protected LocalDate dealDate;
	protected LocalDate deadline;

	public Deal() {
		super();
	}

	public Deal(Product[] products, User seller, User customer, LocalDate dealDate) {
		super();
		this.products = products;
		this.seller = seller;
		this.customer = customer;
		this.dealDate = dealDate;
		this.deadline = dealDate.plusDays(10);
	}

	public double calcFullPrice() {
		double fullPrice = 0;

		for (Product p : products) {
			fullPrice += p.calcPrice();
		}

		return Math.round(fullPrice * 100.0) / 100.0;
	}

	public boolean addProductToDeal(User customer, Product newProduct) {
		if (newProduct == null)
			return false;
		if ((customer.getMoney() - newProduct.calcPrice()) < 0) {
			System.out.println("Недостаточно средств на счёте для осуществления операции");
			return false;
		}

		products = Product.addProductToArray(products, newProduct);
		customer.setMoney(customer.getMoney() - newProduct.calcPrice());
		return true;
	}

	public void removeProductFromDeal(User customer, Product toRemove) {
		if (toRemove == null) {
			return;
		}
		customer.setMoney(customer.getMoney() + toRemove.calcPrice());
		products = Product.removeProductFromArray(products, toRemove);
	}

	public static Deal[] addDealToArray(Deal[] array, Deal newDeal) {
		if (array != null) {
			array = Arrays.copyOf(array, array.length + 1);
			array[array.length - 1] = newDeal;
		} else {
			array = new Deal[1];
			array[0] = newDeal;
		}

		return array;
	}

	public static Deal[] removeDealFromArray(Deal[] array, int index) {
		if (array == null) {
			System.out.println("Ошибка. Массив пустой");
			return null;
		}

		if (array.length == 1) {
			return null;
		}

		Deal[] newArray = new Deal[array.length - 1];

		if (index != 0) {
			System.arraycopy(array, 0, newArray, 0, index);
		}
		System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);

		return newArray;
	}

	public String getProductsDescription() {
		StringBuilder builder = new StringBuilder();

		if (products != null) {
			for (Product p : products) {
				builder.append(p.getDescription());
				builder.append("\n");
			}
		} else {
			builder.append("Пусто");
		}

		return builder.toString();
	}

	public String getBill() {
		StringBuilder builder = new StringBuilder();

		if (products == null) {
			System.out.println("Сделка пуста");
		} else {
			for (Product p : products) {
				builder.append(p.getBillDescription());
				builder.append("\n");
			}
			builder.append("Сумма: " + calcFullPrice() + "\n");
			builder.append("Продавец ");
			builder.append(seller.getFullName() + "\n");
			builder.append(dealDate);
			builder.append("-");
			builder.append(deadline);
		}

		return builder.toString();
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public LocalDate getDealDate() {
		return dealDate;
	}

	public void setDealDate(LocalDate dealDate) {
		this.dealDate = dealDate;
		this.deadline = dealDate.plusDays(10);
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(products);
		result = prime * result + Objects.hash(customer, deadline, dealDate, seller);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deal other = (Deal) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(deadline, other.deadline)
				&& Objects.equals(dealDate, other.dealDate) && Arrays.equals(products, other.products)
				&& Objects.equals(seller, other.seller);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Deal [products=");
		builder.append(Arrays.toString(products));
		builder.append(", seller=");
		builder.append(seller);
		builder.append(", customer=");
		builder.append(customer);
		builder.append(", dealDate=");
		builder.append(dealDate);
		builder.append(", deadline=");
		builder.append(deadline);
		builder.append("]");
		return builder.toString();
	}
}