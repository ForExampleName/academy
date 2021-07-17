package by.academy.lessons.lesson_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo2 {
	static Pattern pattern = Pattern.compile(".+\\.(com|org|ua|ru)");

	public static boolean test(String testString) {
		Matcher matcher = pattern.matcher(testString);
		return matcher.matches();
	}

	public static void main(String[] args) {
		System.out.println(test("google.com"));
		System.out.println(test("reference1.by"));
		System.out.println(test("reference1.org"));
	}

}
