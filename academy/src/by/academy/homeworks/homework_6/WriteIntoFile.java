package by.academy.homeworks.homework_6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteIntoFile {
	private static final String STOP_WORD = "STOP";
	private static final String FILE_PATH = "academy\\src\\by\\academy\\homeworks\\homework_6\\files\\file.txt";

	public static void main(String[] args) {
		String input;

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
				Scanner scanner = new Scanner(System.in)) {
			while (!((input = scanner.nextLine()).equals(STOP_WORD))) {
				writer.write(input);
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}