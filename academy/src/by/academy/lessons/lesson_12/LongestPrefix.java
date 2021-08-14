package by.academy.lessons.lesson_12;

import java.util.HashMap;
import java.util.Map;

public class LongestPrefix {
	private static String getLongestPrefix(String[] array) {
		String longestPrefix = null;
		Map<String, Integer> prefixCounter = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length(); j++) {
				String curSubstring = array[i].substring(0, j + 1);
				prefixCounter.put(curSubstring, prefixCounter.getOrDefault(curSubstring, 0) + 1);
			}
		}

		for (String key : prefixCounter.keySet()) {
			if (prefixCounter.get(key) < 2) {
				continue;
			}

			if (longestPrefix == null || key.length() > longestPrefix.length()) {
				longestPrefix = key;
			}
		}

		return longestPrefix;
	}

	public static void main(String[] args) {
		String[] array = { "test", "test1", "tes", "abc", "abcd", "abcde" };

		System.out.println("Longest prefix is " + getLongestPrefix(array));
	}
}