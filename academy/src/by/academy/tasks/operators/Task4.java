package by.academy.tasks.operators;

public class Task4 {
	public static void main(String[] args) {
		int s = 370_000;
		int sec;
		int m;
		int min;
		int h;
		sec = s % 60;
		m = (s - sec) / 60;
		min = m % 60;
		h = (m - min) / 60;
		System.out.println(h + " hours " + min + " minutes " + sec + " seconds");
		int days = h / 24;
		System.out.println(days + " days");
		int months = days / 30;
		System.out.println(months + " months");
	}

}
