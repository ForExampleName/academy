package by.academy.homeworks.homework_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DeleteSpaces {
	public static final String INPUT_FILE_PATH = "src\\by\\academy\\homeworks\\homework_6\\task2.txt";
	public static final String OUTPUT_FILE_PATH = "src\\by\\academy\\homeworks\\homework_6\\result.txt";

	public static void main(String[] args) {
		try {
			File inputFile = new File(INPUT_FILE_PATH);
			if (!inputFile.exists()) {
				inputFile.createNewFile();
			}

			File outputFile = new File(OUTPUT_FILE_PATH);
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}

			try (FileInputStream fileIn = new FileInputStream(inputFile);
					FileOutputStream fileOut = new FileOutputStream(outputFile);) {
				int curSymbol;
				while ((curSymbol = fileIn.read()) != -1) {
					if (curSymbol == (int) ' ') {
						continue;
					} else {
						fileOut.write(curSymbol);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}