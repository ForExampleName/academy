package by.academy.homeworks.homework_1;

public class PowersOfTwoDemo {

	public static void main(String[] args) {
		int result = 1;

		while (result <= 1_000_000) {
			System.out.println(result);
			result *= 2;
		}
	}
}
