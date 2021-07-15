package by.academy.lessons.lesson_3;

public class Loops {
	
	public static void main(String[] args) {
		int n = 1;
		while (n < 10) {
			System.out.println("Tic-Tac \"n\" is " + n++);
		}
		System.out.println("It's 10\n");

		n = 1;
		do {
			System.out.println("Tic-Tac \"n\" is " + n++);
		} while (n < 10);
		System.out.println("It's 10");
		System.out.println("--------------------------------------------------------------");
	}

}
