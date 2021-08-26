package by.academy.lessons.lesson_14;

import java.util.function.Function;

public class FunctionPredicateDemo {

	public static void main(String[] args) {
		Function<Integer, String> functionLambda = num -> (num < 0) ? "Negative" : (num == 0) ? "Zero" : "Positive";
		System.out.println(functionLambda.apply(-3));
		System.out.println(functionLambda.apply(0));
		System.out.println(functionLambda.apply(3));
	}
}