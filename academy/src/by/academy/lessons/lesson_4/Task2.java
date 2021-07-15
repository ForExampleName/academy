package by.academy.lessons.lesson_4;

import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter string count: ");
		int stringCount = scanner.nextInt();

		scanner.nextLine(); // to pass /n symbol	

		String maxStr = null;
		String minStr = null;
		String current = null;

		for (int i = 0; i < stringCount; i++) {
			System.out.print("Enter string number " + i + " :");
			
			current = scanner.nextLine();
			
			if(maxStr == null) {
				maxStr = current;
				continue;
			}
			
			if(minStr == null) {
				minStr = current;
				continue;
			}
			
			
			if (current.length() > maxStr.length()) {
				maxStr = current;
			}
			if (current.length() < minStr.length()) {
				minStr = current;
			}
		}

		System.out.println("Longest string is \"" + maxStr + "\" it's length is " + maxStr.length());
		System.out.println("Shortest string is \"" + minStr + "\" it's length is " + minStr.length());

		scanner.close();
	}
}
