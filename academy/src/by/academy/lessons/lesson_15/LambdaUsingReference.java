package by.academy.lessons.lesson_15;

import by.academy.lessons.lesson_14.Printable;

public class LambdaUsingReference {
	public static void main(String[] args) {
		Printable lambda = System.out::println;
		lambda.print("Hello, Lambda!!!");
	}
}