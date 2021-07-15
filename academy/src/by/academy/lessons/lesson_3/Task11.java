package by.academy.lessons.lesson_3;

import java.util.Scanner;

public class Task11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		for(int i =0;i<10;i++) {
			System.out.print("¬ведите первое число: ");
			int first_num = scanner.nextInt();
			
			System.out.print("¬ведите второе число: ");
			int second_num = scanner.nextInt();
			
			if(first_num > second_num) {
				System.out.println("ѕервое число больше");
			}else if(second_num > first_num) {
				System.out.println("¬торое число больше");
			}else {
				System.out.println("„исла равны");
			}
		}
		
		
		scanner.close();
	}

}
