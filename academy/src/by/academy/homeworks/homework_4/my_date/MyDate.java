package by.academy.homeworks.homework_4.my_date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class MyDate {
	private Year year;
	private Month month;
	private Day day;

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public MyDate() {
		super();
		LocalDate today = LocalDate.now();
		setDate(today);
	}

	public MyDate(String dateStr) {
		super();
		setDate(dateStr);
	}

	private static LocalDate parse(String dateStr) {
		return LocalDate.parse(dateStr, formatter);
	}

	public void setDate(String dateStr) {
		setDate(parse(dateStr));
	}

	public void setDate(LocalDate date) {
		year = new Year(date.getYear(), date.isLeapYear());
		month = new Month(date.getMonthValue(), date.getMonth());
		day = new Day(date.getDayOfMonth(), date.getDayOfWeek());
	}

	public String getDayOfWeek() {
		return day.getDayOfWeekName();
	}

	public boolean isLeapYear() {
		return year.isLeapYear;
	}

	public String getDateInUsualFormat() {
		StringBuilder builder = new StringBuilder();
		builder.append(day.number + " ");
		builder.append(month.getMonthName());
		builder.append("(-я) ");
		builder.append(year.year);
		builder.append(" года");
		return builder.toString();
	}

	public static long calcDayDifference(LocalDate start, LocalDate end) {
		if (end.isAfter(start)) {
			return ChronoUnit.DAYS.between(start, end);
		}

		return ChronoUnit.DAYS.between(end, start);
	}

	public static long calcDayDifference(MyDate start, MyDate end) {
		LocalDate first = LocalDate.of(start.getYear().year, start.getMonth().number, start.getDay().number);
		LocalDate second = LocalDate.of(end.getYear().year, end.getMonth().number, end.getDay().number);

		return calcDayDifference(first, second);
	}

	public static long calcDayDifference(String start, String end) {
		LocalDate first = parse(start);
		LocalDate second = parse(start);

		return calcDayDifference(first, second);
	}

	private class Year {
		int year;
		boolean isLeapYear;

		public Year(int year, boolean isLeapYear) {
			super();
			this.year = year;
			this.isLeapYear = isLeapYear;
		}

		private MyDate getEnclosingInstance() {
			return MyDate.this;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(isLeapYear, year);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Year other = (Year) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return isLeapYear == other.isLeapYear && year == other.year;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Year [year=");
			builder.append(year);
			builder.append(", isLeapYear=");
			builder.append(isLeapYear);
			builder.append("]");
			return builder.toString();
		}
	}

	private class Month {
		int number;
		java.time.Month month;

		public Month(int number, java.time.Month month) {
			super();
			this.number = number;
			this.month = month;
		}

		private String getMonthName() {
			switch (month) {
			case JANUARY:
				return "Январь";
			case FEBRUARY:
				return "Февраль";
			case MARCH:
				return "Март";
			case APRIL:
				return "Апрель";
			case MAY:
				return "Май";
			case JUNE:
				return "Июнь";
			case JULY:
				return "Июль";
			case AUGUST:
				return "Август";
			case SEPTEMBER:
				return "Сентябрь";
			case OCTOBER:
				return "Октябрь";
			case NOVEMBER:
				return "Ноябрь";
			case DECEMBER:
				return "Декабрь";
			default:
				return "Месяц не найден";
			}
		}

		private MyDate getEnclosingInstance() {
			return MyDate.this;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(month, number);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Month other = (Month) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return month == other.month && number == other.number;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Month [number=");
			builder.append(number);
			builder.append(", month=");
			builder.append(month);
			builder.append("]");
			return builder.toString();
		}
	}

	private class Day {
		int number;
		DayOfWeek dayOfWeek;

		public Day(int number, DayOfWeek dayOfWeek) {
			super();
			this.number = number;
			this.dayOfWeek = dayOfWeek;
		}

		private String getDayOfWeekName() {
			switch (dayOfWeek) {
			case MONDAY:
				return "Понедельник";
			case TUESDAY:
				return "Вторник";
			case WEDNESDAY:
				return "Среда";
			case THURSDAY:
				return "Четверг";
			case FRIDAY:
				return "Пятница";
			case SATURDAY:
				return "Суббота";
			case SUNDAY:
				return "Воскресенье";
			default:
				return "День недели не найден";
			}
		}

		private MyDate getEnclosingInstance() {
			return MyDate.this;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(dayOfWeek, number);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Day other = (Day) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return dayOfWeek == other.dayOfWeek && number == other.number;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Day [number=");
			builder.append(number);
			builder.append(", dayOfWeek=");
			builder.append(dayOfWeek);
			builder.append("]");
			return builder.toString();
		}
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyDate other = (MyDate) obj;
		return Objects.equals(day, other.day) && Objects.equals(month, other.month) && Objects.equals(year, other.year);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyDate [year=");
		builder.append(year);
		builder.append(", month=");
		builder.append(month);
		builder.append(", day=");
		builder.append(day);
		builder.append("]");
		return builder.toString();
	}
}