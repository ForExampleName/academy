package by.academy.lessons.lesson_5.product;

public class ProductDemo {

	public static void main(String[] args) {
		Product product1 = new Product("Apples", 12.5, 15);
		Product product2 = new Product("Oranges", 15.6, 20);
		
		System.out.println(product1);
		System.out.println(product2);
	}
}
