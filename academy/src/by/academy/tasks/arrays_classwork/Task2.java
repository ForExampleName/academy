package by.academy.tasks.arrays_classwork;

import java.util.Arrays;

public class Task2 {

	public static void main(String[] args) {
		String[][] array = { 
				{ "a1", "a2", "a3", "a4", "a5", "a6" }, 
				{ "b1", "b2", "b3", "b4", "b5", "b6" }, 
				{ "c1", "c2", "c3", "c4", "c5", "c6" } 
		};
		
		System.out.println(Arrays.deepToString(array));
	}
}