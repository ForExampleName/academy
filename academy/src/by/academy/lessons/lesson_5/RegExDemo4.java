package by.academy.lessons.lesson_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo4 {
	static Pattern pattern = Pattern.compile("[:;,./\\?!']");
	
	public static void main(String[] args) {
		String str = "qwrty, 1234., zxcvb? , /:";
		Matcher matcher = pattern.matcher(str);
		int count = 0;
		while (matcher.find()) {
			++count;
			System.out.println(str.substring(matcher.start(), matcher.end()));
		}
		System.out.println("Count is " + count);
	}
}
