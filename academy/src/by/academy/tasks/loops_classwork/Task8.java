package by.academy.tasks.loops_classwork;

import java.util.Random;

public class Task8 {
	private static final Random random = new Random();

	public static void main(String[] args) {
		int n = random.nextInt(11);

		System.out.print(n + "! = ");

		if (n == 0) {
			System.out.println("1");
			return;
		}

		int temp = 1;

		for (int i = 1; i <= n; i++) {
			temp *= i;
			System.out.print(i + ((i == n) ? "" : "*"));
		}

		System.out.println(" = " + temp);
	}
}