package by.academy.lessons.lesson_3;

import java.util.Scanner;

public class Task11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		for(int i =0;i<10;i++) {
			System.out.print("Enter first number: ");
			int first_num = scanner.nextInt();
			
			System.out.print("Enter second number: ");
			int second_num = scanner.nextInt();
			
			if(first_num > second_num) {
				System.out.println("First number is bigger");
			}else if(second_num > first_num) {
				System.out.println("Second number is bigger");
			}else {
				System.out.println("Number are equal");
			}
		}
		
		
		scanner.close();
	}

}
