package by.academy.tasks.loops_classwork;

public class Task0 {

	public static void main(String[] args) {
		// put number as zero command line argument
		int number = Integer.parseInt(args[0]);
		if ((number & 1) == 1) {
			System.out.println(number);
		}
	}
}