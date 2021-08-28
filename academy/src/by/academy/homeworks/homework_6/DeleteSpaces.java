package by.academy.homeworks.homework_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteSpaces {
	public static final String INPUT_FILE_PATH = "academy\\src\\by\\academy\\homeworks\\homework_6\\files\\task2.txt";
	public static final String OUTPUT_FILE_PATH = "academy\\src\\by\\academy\\homeworks\\homework_6\\files\\result.txt";

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
				BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
			int curSymbol;

			while ((curSymbol = reader.read()) != -1) {
				if (curSymbol != (int) ' ') {
					writer.write(curSymbol);
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}