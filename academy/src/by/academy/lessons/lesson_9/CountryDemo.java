package by.academy.lessons.lesson_9;

public class CountryDemo {

	public static void main(String[] args) {
		Country<String, Integer, Double> belarus = new Country<>("Belarus", 207000, 9.5);

		System.out.println(belarus.toString());
		System.out.println();
		System.out.println(belarus.showFieldTypes());
	}
}