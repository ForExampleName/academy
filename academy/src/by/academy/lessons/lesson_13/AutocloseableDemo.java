package by.academy.lessons.lesson_13;

import java.io.IOException;

public class AutocloseableDemo {

	public static void main(String[] args) throws IOException {
		try (Autocloseable instance = new Autocloseable()) {
			System.out.println("First try-with-resources block");
		}

		try (Autocloseable instance = new Autocloseable()) {
			System.out.println("Second try-with-resources block");
			if (Integer.valueOf(args[0]) == 1) // args[0] should be "1"
				throw new RuntimeException();
			System.out.println("After");
		}
	}
}