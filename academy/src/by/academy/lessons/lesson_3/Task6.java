package by.academy.lessons.lesson_3;

import java.util.Scanner;

public class Task6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("������� ������ �����: ");
		int first_num = scanner.nextInt();
		
		System.out.print("������� ������ �����: ");
		int second_num = scanner.nextInt();
		
		if(first_num > second_num)
			System.out.println("������� ����� ��� " + first_num + "\n" + "������� ����� ��� " + second_num) ;
		else
			System.out.println("������� ����� ��� " + second_num + "\n" + "������� ����� ��� " + first_num);
				
		
		System.out.println("������� �������������� ��������� ����� ����� " + ((first_num + second_num) / 2.0));		
		scanner.close();
	}

}
