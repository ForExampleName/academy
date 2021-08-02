package by.academy.homeworks.homework_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeFormatterDemo {
	private static final Scanner scanner = new Scanner(System.in);

	private static final DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public static void main(String[] args) {
		String dateStr;

		System.out.print("Enter date using format dd/MM/yyyy: ");
		dateStr = scanner.nextLine();

		LocalDate date = LocalDate.parse(dateStr, formatter1);
		System.out.println(date);

		System.out.print("День: " + date.getDayOfMonth() + "\n");
		System.out.print("Месяц: " + date.getMonthValue() + "\n");
		System.out.print("Год: " + date.getYear() + "\n");

		System.out.print("Enter date using format dd-MM-yyyy: ");
		dateStr = scanner.nextLine();

		date = LocalDate.parse(dateStr, formatter2);
		System.out.println(date);

		System.out.print("День: " + date.getDayOfMonth() + "\n");
		System.out.print("Месяц: " + date.getMonthValue() + "\n");
		System.out.print("Год: " + date.getYear());

		scanner.close();
	}
}