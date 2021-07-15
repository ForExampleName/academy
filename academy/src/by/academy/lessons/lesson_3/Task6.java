package by.academy.lessons.lesson_3;

import java.util.Scanner;

public class Task6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Введите первое число: ");
		int first_num = scanner.nextInt();
		
		System.out.print("Введите второе число: ");
		int second_num = scanner.nextInt();
		
		if(first_num > second_num)
			System.out.println("Большее число это " + first_num + "\n" + "Меньшее число это " + second_num) ;
		else
			System.out.println("Большее число это " + second_num + "\n" + "Меньшее число это " + first_num);
				
		
		System.out.println("Среднее арифметическое введенных чисел равно " + ((first_num + second_num) / 2.0));		
		scanner.close();
	}

}
