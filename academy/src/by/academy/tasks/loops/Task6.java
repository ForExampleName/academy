package by.academy.tasks.loops;

import java.util.Scanner;

public class Task6 {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Enter sum of money: ");
		double money = scanner.nextDouble();
		
		System.out.print("Enter years count: ");
		int years = scanner.nextInt();
		
		double procent = 0.03D;
		
		for(int i=0;i<years;i++) {
			money += (money*procent);
		}
		
		System.out.println(money);
		
		scanner.close();
	}
}