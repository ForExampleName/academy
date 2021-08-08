package by.academy.homeworks.homework_4.my_date;

import java.time.LocalDate;
import java.util.Scanner;

import by.academy.homeworks.homework_3.validators.DateValidator;

public class MyDateDemo {
	private static final DateValidator dateValidator = new DateValidator();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		MyDate myDate = new MyDate();
		System.out.println(myDate.getDateInUsualFormat());

		System.out.println(myDate.getDayOfWeek());
		System.out.println("Данный год " + ((myDate.isLeapYear()) ? "високосный" : "не високосный"));

		myDate.setDate(LocalDate.now().plusDays(7));
		System.out.println(myDate.getDateInUsualFormat());

		System.out.print("Введите первую дату в формате dd/MM/yyyy:");
		String firstDate = scanner.nextLine();

		System.out.print("Введите вторую дату в формате dd/MM/yyyy:");
		String secondDate = scanner.nextLine();

		if (dateValidator.validate(firstDate) && dateValidator.validate(secondDate)) {
			MyDate date1 = new MyDate(firstDate);
			MyDate date2 = new MyDate(secondDate);

			System.out.println("01/07/2021 - 16/09/2021 = " + MyDate.calcDayDifference(date1, date2) + " дней");
		}

		scanner.close();
	}
}