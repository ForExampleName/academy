package by.academy.lessons.lesson_7.deal_project;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Deal {
	private Product[] products;
	private User buyer;
	private User seller;
	private LocalDate dealDate;

	public Deal() {
		super();
	}

	public Deal(Product[] products, User buyer, User seller, LocalDate dealDate) {
		super();
		this.products = products;
		this.buyer = buyer;
		this.seller = seller;
		this.dealDate = dealDate;
	}

	public double calcFullPrice() {
		double fullPrice = 0;
		
		for (Product p : products) {
			fullPrice += p.calcPrice();
		}

		return fullPrice;
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public LocalDate getDealDate() {
		return dealDate;
	}

	public void setDealDate(LocalDate dealDate) {
		this.dealDate = dealDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(products);
		result = prime * result + Objects.hash(buyer, dealDate, seller);
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
		return Objects.equals(buyer, other.buyer) && Objects.equals(dealDate, other.dealDate)
				&& Arrays.equals(products, other.products) && Objects.equals(seller, other.seller);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Deal [products=");
		builder.append(Arrays.toString(products));
		builder.append(", buyer=");
		builder.append(buyer);
		builder.append(", seller=");
		builder.append(seller);
		builder.append(", dealDate=");
		builder.append(dealDate);
		builder.append("]");
		return builder.toString();
	}
}