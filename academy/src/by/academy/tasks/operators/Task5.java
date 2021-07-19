package by.academy.tasks.operators;

import java.util.Scanner;

public class Task5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter first number: ");
		int first_num = scanner.nextInt();
		
		System.out.print("Enter second number: ");
		int second_num = scanner.nextInt();
		
		if(first_num > second_num)
			System.out.println("Bigger number is " + first_num + "\n" + "Lower number is " + second_num) ;
		else
			System.out.println("Bigger number is " + second_num + "\n" + "Lower number is " + first_num);
				
		
		System.out.println("Average of your numbers is " + ((first_num + second_num) / 2.0));		
		scanner.close();
	}

}
