package by.academy.lessons.lesson_13;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import by.academy.deal.entities.products.Product;
import by.academy.deal.entities.products.TV;
import by.academy.deal.enums.Resolution;

public class SerializeDemo {

	public static void main(String[] args) {
		Product product = new TV("Samsung", 2200.0D, 3, "QE55Q77TAU", 55.0F, Resolution.UHD);

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("src\\by\\academy\\deal\\object.txt")))) {
			oos.writeObject(product);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("src\\by\\academy\\deal\\object.txt")))) {
			Product productFromFile = (Product) ois.readObject();
			System.out.println(productFromFile);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}