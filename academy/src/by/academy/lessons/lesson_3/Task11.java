package by.academy.lessons.lesson_3;

import java.util.Scanner;

public class Task11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		for(int i =0;i<10;i++) {
			System.out.print("������� ������ �����: ");
			int first_num = scanner.nextInt();
			
			System.out.print("������� ������ �����: ");
			int second_num = scanner.nextInt();
			
			if(first_num > second_num) {
				System.out.println("������ ����� ������");
			}else if(second_num > first_num) {
				System.out.println("������ ����� ������");
			}else {
				System.out.println("����� �����");
			}
		}
		
		
		scanner.close();
	}

}
