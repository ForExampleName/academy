package by.academy.deav_v2.entities.deal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import by.academy.deav_v2.description.DescriptionProvider;
import by.academy.deav_v2.entities.products.Product;
import by.academy.deav_v2.entities.storage.account.User;

public class Deal {
	protected List<Product> products;
	protected User seller;
	protected User customer;
	protected LocalDate dealDate;
	protected LocalDate deadline;

	public Deal() {
		super();
		products = new ArrayList<>();
	}

	public Deal(List<Product> products, User seller, User customer, LocalDate dealDate) {
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

	public boolean addProduct(Product newProduct) {
		if (newProduct == null)
			return false;

		if ((customer.getMoney() - newProduct.calcPrice()) < 0) {
			System.out.println("Недостаточно средств на счёте для осуществления операции");
			return false;
		}

		Product.addProductToList(newProduct, products);

		customer.setMoney(customer.getMoney() - newProduct.calcPrice());
		return true;
	}

	public boolean removeProduct(Product toRemove) {
		if (toRemove == null) {
			return false;
		}

		if (!Product.removeProductFromList(toRemove, products)) {
			System.out.println("Указанный продукт не найден в сделке");
			return false;
		}

		customer.setMoney(customer.getMoney() + toRemove.calcPrice());
		return true;
	}

	public boolean isEmpty() {
		return products.isEmpty();
	}

	public String getProductsDescription() {
		StringBuilder description = new StringBuilder();

		for (Product p : products) {
			description.append(DescriptionProvider.getDescription(p));
			description.append("\n");
		}

		return description.toString();
	}

	public String getBill() {
		StringBuilder bill = new StringBuilder();

		for (Product p : products) {
			bill.append(DescriptionProvider.getBillDescription(p));
			bill.append("\n");
		}

		bill.append("Сумма: " + calcFullPrice() + "\n");
		bill.append("Продавец ");
		bill.append(seller.getFullName() + "\n");
		bill.append(dealDate);
		bill.append("-");
		bill.append(deadline);

		return bill.toString();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
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
		return Objects.hash(customer, deadline, dealDate, products, seller);
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
				&& Objects.equals(dealDate, other.dealDate) && Objects.equals(products, other.products)
				&& Objects.equals(seller, other.seller);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Deal [products=");
		builder.append(products);
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