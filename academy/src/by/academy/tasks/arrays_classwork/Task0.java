package by.academy.tasks.arrays_classwork;

public class Task0 {

	public static void main(String[] args) {
		String[] daysOfTheWeek = new String[7];
		
		daysOfTheWeek[0] = "Monday";
		daysOfTheWeek[1] = "Tuesday";
		daysOfTheWeek[2] = "Wednesday";
		daysOfTheWeek[3] = "Thursday";
		daysOfTheWeek[4] = "Friday";
		daysOfTheWeek[5] = "Saturday";
		daysOfTheWeek[6] = "Sunday";
		
		System.out.println("Last day of week is " + daysOfTheWeek[daysOfTheWeek.length - 1]);
	}
}