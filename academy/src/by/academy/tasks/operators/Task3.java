package by.academy.tasks.operators;

import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		System.out.print("Enter number: ");
		
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();
		
		if(value % 2 == 0)
			System.out.println("Your number is even");
		else
			System.out.println("Your number is odd");
		
		scanner.close();
	}

}
