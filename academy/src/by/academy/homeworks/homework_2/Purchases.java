package by.academy.homeworks.homework_2;

import java.util.Scanner;

public class Purchases {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the amount of purchases: ");

		/* Use symbol ',' for entering floating point numbers */
		double sum = scanner.nextDouble();

		System.out.print("Enter the age of the customer: ");
		short age = scanner.nextShort();

		float discount = 0F;

		if (sum < 100) {
			discount = 0.05F;
		} else if (sum >= 100 && sum < 200) {
			discount = 0.07F;
		} else if (sum >= 200 && sum < 300) {
			if (age > 18) {
				discount = 0.16F;
			} else {
				discount = 0.09F;
			}
		} else if (sum >= 300 && sum < 400) {
			discount = 0.15F;
		} else if (sum >= 400) {
			discount = 0.2F;
		}

		double finalPrice = Math.round(sum * (1 - discount) * 100.0) / 100.0;

		System.out.println("Your final price is " + finalPrice);

		scanner.close();
	}

}
