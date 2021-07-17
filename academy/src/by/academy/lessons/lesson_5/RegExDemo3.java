package by.academy.lessons.lesson_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo3 {
	static Pattern pattern = Pattern.compile("[Java]+ [0-9]+");

	public static void main(String[] args) {
		String str = "Versions: Java 5, Java 6, Java 7, Java 8, Java 9, Java 10, Java 11, Java 12.";

		Matcher matcher = pattern.matcher(str);

		while (matcher.find()) {
			System.out.println(str.substring(matcher.start(), matcher.end()));
		}
	}
}
