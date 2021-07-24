package by.academy.lessons.lesson_7.deal_project;

import java.time.LocalDate;

public class Market {
	private static final int PRODUCT_COUNT = 3;

	public static void main(String... args) {
		User buyer = new User("Vasya", 12000);
		User seller = new User("Vova", 8000);

		Product[] products = new Product[PRODUCT_COUNT];

		String[] authors = new String[1];
		authors[0] = new String("Lewis Carroll");

		products[0] = new Book("Alice in wonderland", 1000.0, 1, authors, 700);
		products[1] = new BoardGame("Monopoly", 1500.0, 1, 12, "Monopoly instruction");
		products[2] = new BoardGame("Jenga", 1500.0, 2, 6, "Jenga instruction");

		Deal deal = new Deal();

		deal.setProducts(products);
		deal.setBuyer(buyer);
		deal.setSeller(seller);
		deal.setDealDate(LocalDate.of(2021, 7, 24));

		System.out.println(deal);
		System.out.println(deal.calcFullPrice());
	}
}