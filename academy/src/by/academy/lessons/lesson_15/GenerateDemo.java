package by.academy.lessons.lesson_15;

import java.util.Random;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class GenerateDemo {
	private static final int BORDER = 1000;
	private static final int SECOND_LIMIT = 200;
	private static final int SKIP_COUNT = 50;
	private static final Random random = new Random();

	private static Stream<String> getStream() {
		return Stream.generate(() -> random.nextInt(BORDER)).limit(BORDER).skip(SKIP_COUNT)
				.filter(i -> (i & 1) == 0 && i != 0).sorted().distinct().map(i -> "Число " + i).limit(SECOND_LIMIT);
	}

	public static void main(String[] args) {
		System.out.println(getStream().collect(Collectors.toList()));
		System.out.println(getStream().anyMatch(i -> i.equals("Число 500")));
		System.out.println(getStream().min((i1, i2) -> i1.length() - i2.length()).get());
		System.out.println(getStream().max((i1, i2) -> i1.length() - i2.length()).get());
	}
}