package by.academy.tasks.loops_classwork;

public class Task2 {

	public static void main(String[] args) {
		// put number as zero command line argument
		int dayNumber = Integer.parseInt(args[0]);

		if (dayNumber < 1 || dayNumber > 7) {
			System.out.println("Wrong day number");
			return;
		}

		if (dayNumber == 1) {
			System.out.println("Monday");
		} else if (dayNumber == 2) {
			System.out.println("Tuesday");
		} else if (dayNumber == 3) {
			System.out.println("Wednesday");
		} else if (dayNumber == 4) {
			System.out.println("Thursday");
		} else if (dayNumber == 5) {
			System.out.println("Friday");
		} else {
			System.out.println("Weekend");
		}
	}
}