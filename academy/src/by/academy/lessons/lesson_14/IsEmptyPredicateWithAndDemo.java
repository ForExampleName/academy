package by.academy.lessons.lesson_14;

import java.util.function.Predicate;

public class IsEmptyPredicateWithAndDemo {

	public static void main(String[] args) {
		Predicate<String> isNotNullPredicate = toTest -> toTest != null;
		Predicate<String> isEmptyPredicate = toTest -> toTest.length() != 0;

		String str = null;
		System.out.println("String is not null and not empty? " + isNotNullPredicate.and(isEmptyPredicate).test(str));

		str = new String();
		System.out.println("String is not null and not empty? " + isNotNullPredicate.and(isEmptyPredicate).test(str));

		str = new String("Not empty string");
		System.out.println("String is not null and not empty? " + isNotNullPredicate.and(isEmptyPredicate).test(str));
	}
}