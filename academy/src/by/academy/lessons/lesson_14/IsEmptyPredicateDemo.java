package by.academy.lessons.lesson_14;

import java.util.function.Predicate;

public class IsEmptyPredicateDemo {

	public static void main(String[] args) {
		Predicate<String> isEmptyPredicate = toTest -> toTest == null || toTest.length() == 0;

		String str = null;
		System.out.println("String is empty? " + isEmptyPredicate.test(str));

		str = new String();
		System.out.println("String is empty? " + isEmptyPredicate.test(str));

		str = new String("Not empty string");
		System.out.println("String is empty? " + isEmptyPredicate.test(str));
	}
}