package by.academy.tasks.loops_classwork;

public class Task3 {

	public static void main(String[] args) {
		// put number as zero command line argument
		int dayNumber = Integer.parseInt(args[0]);

		if (dayNumber < 1 || dayNumber > 7) {
			System.out.println("Wrong day number");
			return;
		}

		switch (dayNumber) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		default:
			System.out.println("Weekend");
		}
	}
}