package by.academy.lessons.lesson_3;

import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) {
		System.out.print("������� �����: ");
		
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();
		
		if(value % 2 == 0)
			System.out.println("����� ������");
		else
			System.out.println("����� ��������");
		
		scanner.close();
	}

}
