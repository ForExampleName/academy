package by.academy.lessons.lesson_3;

import java.util.Scanner;

public class Task9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������� ���������� ��������: ");
		int n = scanner.nextInt();
		
		int positiveCount = 0;
		int negativeCount = 0;
		int zeroCount = 0;
		
		int currentNum = 0;
		
		for (int i = 0; i < n; i++) {
			currentNum = scanner.nextInt();
			if(currentNum > 0) {
				++positiveCount;
			}
			else if (currentNum < 0) {
				++negativeCount;
			}
			else {
				++zeroCount;
			}
		}
		
		System.out.println("�������������: " + positiveCount);
		System.out.println("�������������: " + negativeCount);
		System.out.println("�����: " + zeroCount);
		
		scanner.close();
	}

}
