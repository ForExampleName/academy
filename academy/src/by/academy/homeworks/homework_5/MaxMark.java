package by.academy.homeworks.homework_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MaxMark {

	private static String getMarks(List<Integer> marks) {
		StringBuilder builder = new StringBuilder();
		Iterator<Integer> iterator = marks.iterator();

		while (iterator.hasNext()) {
			builder.append(iterator.next());
			builder.append(" ");
		}

		return builder.toString();
	}

	private static Integer findMaxMark(List<Integer> marks) {
		if (marks.isEmpty()) {
			return null;
		}

		Iterator<Integer> iterator = marks.iterator();

		Integer max = iterator.next();
		Integer current = null;

		while (iterator.hasNext()) {
			current = iterator.next();
			if (current > max) {
				max = current;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> marks = new ArrayList<>();

		String marksStr = null;
		String input = null;

		do {
			marksStr = getMarks(marks);
			System.out.println((marksStr.length() != 0) ? "Marks:" + marksStr : "Marks not found");

			System.out.print("Enter mark:");
			input = scanner.nextLine();

			marks.add(Integer.parseInt(input));

			System.out.print("Continue?(y/n):");
			input = scanner.nextLine();
		} while (!input.equals("n"));

		Integer max = findMaxMark(marks);

		System.out.println((max == null) ? "There is no max mark" : "Max mark is " + max);

		scanner.close();
	}
}
