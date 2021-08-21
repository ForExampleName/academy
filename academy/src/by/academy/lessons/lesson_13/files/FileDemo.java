package by.academy.lessons.lesson_13.files;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FileDemo {

	public static void main(String[] args) {
		File directory = new File("src\\by\\academy\\lessons\\lesson_13\\files\\io");

		if (!directory.exists()) {
			directory.mkdir();
		}

		List<File> files = new ArrayList<>();

		File firstFile = new File(directory.getPath() + "\\file.txt");
		if (!firstFile.exists()) {
			try {
				firstFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		files.add(firstFile);

		File secondFile = new File(directory.getPath() + "\\user.txt");
		if (!secondFile.exists()) {
			try {
				secondFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		files.add(secondFile);

		System.out.println("--------------------------------------------------------------");
		for (File f : files) {
			System.out.println("File " + f.getName());
			System.out.println("File " + f.getName() + " absolute path: " + f.getAbsolutePath());
			System.out.println("Size of " + f.getName() + " is " + f.getTotalSpace());
			System.out.println("Last modified " + Instant.ofEpochMilli(f.lastModified()));
			System.out.println("--------------------------------------------------------------");
		}
	}
}