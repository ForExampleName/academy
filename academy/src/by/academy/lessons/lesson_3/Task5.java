package by.academy.lessons.lesson_3;

public class Task5 {
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
		System.out.println(h + " ����� (-�) " + min + " ����� (-�) " + sec + " ������ (-�)");
		int days = h / 24;
		System.out.println(days + " ����");
		int months = days / 30;
		System.out.println(months + " �������");
	}

}
