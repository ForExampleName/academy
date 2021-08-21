package by.academy.deav_v2.entities.deal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import by.academy.deav_v2.entities.products.Product;
import by.academy.deav_v2.entities.storage.account.User;

public final class DealList {
	private List<Deal> deals;

	public DealList() {
		super();
		deals = new ArrayList<>();
	}

	public DealList(List<Deal> deals) {
		super();
		this.deals = deals;
	}

	public void addDeal(Deal deal) {
		deals.add(deal);
	}

	public Deal completeDeal(int index, User seller) {
		Deal completedDeal = deals.remove(index);
		completedDeal.setSeller(seller);
		seller.setMoney(seller.getMoney() + completedDeal.calcFullPrice());
		return completedDeal;
	}

	public List<Product> removeDeal(int index) {
		Deal removingDeal = deals.remove(index);
		User customer = removingDeal.getCustomer();
		customer.setMoney(customer.getMoney() + removingDeal.calcFullPrice());
		return removingDeal.getProducts();
	}
	
	public Deal getDeal(int index) {
		return deals.get(index);
	}

	public boolean isEmpty() {
		return deals.isEmpty();
	}

	public int getDealsCount() {
		return deals.size();
	}

	public String getDealDescription(int index) {
		return "Сделка №" + (index + 1) + "\n" + deals.get(index).getProductsDescription();
	}

	public String getAllDealsDescription() {
		StringBuilder dealsDescription = new StringBuilder();

		for (int i = 0; i < deals.size(); i++) {
			Deal currentDeal = deals.get(i);
			System.out.println("-------------------------------------------------------------");
			dealsDescription.append("Сделка №");
			dealsDescription.append((i + 1) + "\n");

			dealsDescription.append(currentDeal.getProductsDescription() + "\n");
			dealsDescription.append("Период осуществления сделки:");
			dealsDescription.append(currentDeal.getDealDate() + "-" + currentDeal.getDeadline() + "\n");
			dealsDescription.append("Сумма сделки:");
			dealsDescription.append(currentDeal.calcFullPrice() + "\n");
			System.out.println("-------------------------------------------------------------");
			dealsDescription.append("\n");
		}

		return dealsDescription.toString();
	}

	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}

	@Override
	public int hashCode() {
		return Objects.hash(deals);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DealList other = (DealList) obj;
		return Objects.equals(deals, other.deals);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DealList [deals=");
		builder.append(deals);
		builder.append("]");
		return builder.toString();
	}
}
