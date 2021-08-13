package by.academy.homeworks.homework_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LetterDictionary {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Map<Character, Integer> dictionary = new HashMap<>();
		System.out.print("Enter your string:");
		
		String str = scanner.nextLine();
		
		for(Character letter: str.toCharArray()) {
			dictionary.put(letter, dictionary.getOrDefault(letter, 0) + 1);
		}
		
		for(Character key: dictionary.keySet()) {
			System.out.println(key + " : " + dictionary.get(key) + " times");
		}
		
		scanner.close();
	}
}