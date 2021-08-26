package by.academy.lessons.lesson_14;

import java.util.function.Predicate;

public class StartsEndsWithPredicateDemo {
	public static void main(String[] args) {
		Predicate<String> startsWithJPredicate = word -> word.startsWith("J");
		Predicate<String> startsWithNPredicate = word -> word.startsWith("N");
		Predicate<String> endsWithPredicate = word -> word.endsWith("A");

		String word1 = "Java";
		String word2 = "Namespace";
		String word3 = "JavA";

		System.out.println("Word \"" + word1 + "\" starts with \'J\' or \'N\' and ends with \'A\'? "
				+ startsWithJPredicate.or(startsWithNPredicate).and(endsWithPredicate).test(word1));
		System.out.println("Word \"" + word2 + "\" starts with \'J\' or \'N\' and ends with \'A\'? "
				+ startsWithJPredicate.or(startsWithNPredicate).and(endsWithPredicate).test(word2));
		System.out.println("Word \"" + word3 + "\" starts with \'J\' or \'N\' and ends with \'A\'? "
				+ startsWithJPredicate.or(startsWithNPredicate).and(endsWithPredicate).test(word3));
	}
}