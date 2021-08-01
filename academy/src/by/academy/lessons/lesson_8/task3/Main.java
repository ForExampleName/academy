package by.academy.lessons.lesson_8.task3;

public class Main {
	private static void m(Season s) {
		System.out.println("I very like " + s);
		
		switch(s) {
		case Winter:
			System.out.println("I like Winter");
			break;
		case Spring:
			System.out.println("I like Spring");
			break;
		case Summer:
			System.out.println("I like Summer");
			break;
		case Autumn:
			System.out.println("I like Autumn");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Season favourite = Season.Winter;
		
		System.out.println(favourite);
		System.out.println(favourite.ordinal() + "\n");
		
		m(favourite);
		
		for(Season s: Season.values()) {
			System.out.println(s);
			System.out.println(s.getAverageTemperature());
			System.out.println(s.getDescription() + "\n");
		}
	}
}