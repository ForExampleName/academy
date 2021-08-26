package by.academy.homeworks.homework_6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteIntoFile {
	public static final String STOP_WORD = "STOP";

	public static void main(String[] args) {
		String input;
		try (Scanner scanner = new Scanner(System.in);
				BufferedWriter writer = new BufferedWriter(
						new FileWriter("src\\by\\academy\\homeworks\\homework_6\\file.txt"))) {
			while (true) {
				input = scanner.nextLine();

				if (input.equals(STOP_WORD))
					break;

				writer.write(input);
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}