package by.academy.lessons.lesson_4;

public class Task3 {
	private static void complicatedMethod(String str) {
		System.out.println(str.charAt(str.length() - 1));
		
		System.out.println(str.endsWith("!!!"));
		
		System.out.println(str.startsWith("I like"));
		
		System.out.println(str.contains("Java"));
		
		System.out.println(str.indexOf("Java"));
		
		System.out.println(str.startsWith("I like"));
		
		System.out.println(str.replace("a", "o"));
		
		System.out.println(str.toUpperCase());
		
		System.out.println(str.toLowerCase());
		
		System.out.println(str.substring(7, 11));
	}

	public static void main(String[] args) {
		complicatedMethod("I like Java");
	}
}
