package by.academy.lessons.lesson_14;

import java.util.function.Consumer;

import by.academy.deal.entities.products.MobilePhone;
import by.academy.deal.entities.products.Product;
import by.academy.deal.enums.Color;

public class ConsumerLambdaDemo {
	public static void main(String[] args) {
		Consumer<Product> resive = product -> System.out.println("Отгрузили продукт " + product.getName());
		Consumer<Product> send = product -> System.out.println("Отправляем продукт " + product.getName());

		Product product = new MobilePhone("Samsung", 1800.0D, 2, "Galaxy S20", Color.BLACK, 12.0F);
		resive.andThen(send).accept(product);
	}
}