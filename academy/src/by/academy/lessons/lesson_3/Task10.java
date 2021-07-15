package by.academy.lessons.lesson_3;

import java.util.Scanner;

public class Task10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Введите сумму: ");
		int money = scanner.nextInt();
		
		System.out.print("Введите период хранения (в годах): ");
		int time = scanner.nextInt();
		
		double temp = money;
		for(int i=0;i<time;i++) {
			temp = temp + temp * 0.03;
		}
		
		System.out.println("В конце периода хранения Вы получите: " + temp + " у.е");
		scanner.close();
	}

}
