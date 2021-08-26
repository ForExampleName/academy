package by.academy.lessons.lesson_14;

import java.util.function.Predicate;

public class IsNullPredicateDemo {

	public static void main(String[] args) {
		Predicate<String> isNullPredicate = toTest -> toTest == null;

		String str = null;
		System.out.println("String is null? " + isNullPredicate.test(str));

		str = new String("Not null string");
		System.out.println("String is null? " + isNullPredicate.test(str));
	}
}