package by.academy.lessons.lesson_13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static final String INPUT_FILE_PATH = "src\\by\\academy\\lessons\\lesson_13\\files\\io\\file.txt";
	public static final String OUTPUT_FILE_PATH = "src\\by\\academy\\lessons\\lesson_13\\files\\io\\user.txt";

	public static void main(String[] args) throws IOException {
		File dir = new File("src\\by\\academy\\lessons\\lesson_13\\files\\io");

		if (!dir.exists()) {
			dir.mkdirs();
		}

		File inputFile = new File(INPUT_FILE_PATH);
		if (!inputFile.exists()) {
			inputFile.createNewFile();
		}

		File outputFile = new File(OUTPUT_FILE_PATH);
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}

		FileInputStream fileIn = new FileInputStream(inputFile);
		FileOutputStream fileOut = new FileOutputStream(outputFile);

		int a;
		while ((a = fileIn.read()) != -1) {
			if (a == (int) ' ') {
				fileOut.write((int) '_');
			} else {
				fileOut.write(a);
			}
		}

		fileIn.close();
		fileOut.close();
	}
}
