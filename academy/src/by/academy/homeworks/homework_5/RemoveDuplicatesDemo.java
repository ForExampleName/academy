package by.academy.homeworks.homework_5;

import java.util.Collection;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesDemo {
	private static <T> HashSet<T> removeDuplicates(Collection<T> withDuplicates) {
		return new HashSet<T>(withDuplicates);
	}

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 4, 5, 3, 2, 8, 5, 6, 7 };

		List<Integer> list = new ArrayList<>(Arrays.asList(array));

		System.out.println(removeDuplicates(list).toString());
	}
}
