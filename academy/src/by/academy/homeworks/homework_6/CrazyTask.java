package by.academy.homeworks.homework_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CrazyTask {
	private static final String CRAZY_DIRECTORY = "academy\\src\\by\\academy\\homeworks\\homework_6\\files\\CRAZY";
	private static final String EXAMPLE_FILE = "academy\\src\\by\\academy\\homeworks\\homework_6\\files\\task2.txt";

	private static String getFilePathUsingFileName(String fileName) {
		StringBuilder filePath = new StringBuilder();

		filePath.append(CRAZY_DIRECTORY);
		filePath.append("\\");
		filePath.append(fileName);

		return filePath.toString();
	}

	private static String getFilePathUsingFileNumber(int fileNumber) {
		StringBuilder filePath = new StringBuilder();

		filePath.append(CRAZY_DIRECTORY);
		filePath.append("\\");
		filePath.append(fileNumber);
		filePath.append(".txt");

		return filePath.toString();
	}

	public static void main(String[] args) {
		File crazyDirectory = new File(CRAZY_DIRECTORY);
		if (!crazyDirectory.exists()) {
			crazyDirectory.mkdirs();
		}

		StringBuilder textBuilder = new StringBuilder();
		String text = null;
		String curLine = null;

		Random random = new Random();

		try (BufferedReader reader = new BufferedReader(new FileReader(EXAMPLE_FILE))) {
			while ((curLine = reader.readLine()) != null) {
				textBuilder.append(curLine + "\n");
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		text = textBuilder.toString();

		for (int i = 1; i <= 100; i++) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePathUsingFileNumber(i)))) {
				writer.write(text.substring(0, random.nextInt(text.length())));
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(CRAZY_DIRECTORY + "\\result.txt"))) {
			for (String fileName : crazyDirectory.list()) {
				writer.write(fileName);
				writer.write(" = ");
				writer.write(String.valueOf(new File(getFilePathUsingFileName(fileName)).length()));
				writer.write(" байт");
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}