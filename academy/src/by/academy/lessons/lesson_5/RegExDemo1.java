package by.academy.lessons.lesson_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo1 {
	static Pattern pattern = Pattern.compile("c+(ab)");

	public static void main(String[] args) {

		String str = "cab ccab cccab ab";

		Matcher matcher = pattern.matcher(str);

		while (matcher.find()) {
			System.out.println(str.substring(matcher.start(), matcher.end()));
		}
	}
}
