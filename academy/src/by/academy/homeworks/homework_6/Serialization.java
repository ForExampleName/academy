package by.academy.homeworks.homework_6;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
	private static final String USERS_DIRECTORY = "academy\\src\\by\\academy\\homeworks\\homework_6\\files\\users";

	private static String getFilePathUsingUserObject(User user) {
		StringBuilder filePath = new StringBuilder();

		filePath.append(USERS_DIRECTORY);
		filePath.append("\\");
		filePath.append(user.getFirstName());
		filePath.append("_");
		filePath.append(user.getLastName());
		filePath.append(".txt");

		return filePath.toString();
	}

	public static void main(String[] args) {
		List<User> users = new ArrayList<>();

		users.add(new User("Иван", "Исаков", 31));
		users.add(new User("Николай", "Кудрявцев", 48));
		users.add(new User("Георгий", "Белов", 23));
		users.add(new User("Сергей", "Панфилов", 24));
		users.add(new User("Анатолий", "Захаров", 35));
		users.add(new User("Диана", "Смирнова", 21));
		users.add(new User("Ольга", "Фёдорова", 19));
		users.add(new User("Василиса", "Ткаченко", 28));
		users.add(new User("София", "Титова", 20));
		users.add(new User("Мария", "Кондратьева", 40));

		File usersDir = new File(USERS_DIRECTORY);
		if (!usersDir.exists()) {
			usersDir.mkdirs();
		}

		for (User user : users) {
			try (ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(getFilePathUsingUserObject(user))))) {
				oos.writeObject(user);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}