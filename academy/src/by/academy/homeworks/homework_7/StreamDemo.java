package by.academy.homeworks.homework_7;

import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
	private static final int GENERATE_BORDER = 101;
	private static final int LIMIT_VALUE = 100;
	private static final int FILTER_BORDER = 100;
	private static final int SKIP_VALUE = 3;

	private static final Function<Double, String> valueFunction = (value) -> {
		StringBuilder valueStr = new StringBuilder();

		valueStr.append("Number: ");
		valueStr.append(value);

		return valueStr.toString();
	};

	public static void main(String[] args) {
		Map<Double, String> map = Stream
				.generate(() -> (long) new Random().nextInt(GENERATE_BORDER))
				.limit(LIMIT_VALUE)
				.map((i) -> i * Math.PI - 20)
				.filter((i) -> i < FILTER_BORDER)
				.sorted()
				.skip(SKIP_VALUE)
				.collect(Collectors.toMap(Function.identity(),
						// valueFunction,
						(v) -> "Number: " + v, (s, a) -> s));

		for (Double d : map.keySet()) {
			System.out.println(map.get(d));
		}
	}
}