package by.academy.lessons.lesson_3;

import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������� �������� ������: ");
		String month = scanner.nextLine();
		
		switch(month) {
			case "������":
				System.out.println("1");
				break;
			case "�������":
				System.out.println("2");
				break;
			case "����":
				System.out.println("3");
				break;
			case "������":
				System.out.println("4");
				break;
			case "���":
				System.out.println("5");
				break;
			case "����":
				System.out.println("6");
				break;
			case "����":
				System.out.println("7");
				break;
			case "������":
				System.out.println("8");
				break;
			case "��������":
				System.out.println("9");
				break;
			case "�������":
				System.out.println("10");
				break;
			case "������":
				System.out.println("11");
				break;
			case "�������":
				System.out.println("12");
				break;
			default:
				System.out.println("�� ����(");
		}
			
		scanner.close();
	}

}
