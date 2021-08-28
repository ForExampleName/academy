package by.academy.lessons.lesson_15;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		Random random = new Random();

		Supplier<Integer> suplierLambda = () -> random.nextInt(11);

		for (int i = 0; i < 20; i++) {
			System.out.println(suplierLambda.get());
		}
	}
}