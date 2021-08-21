package by.academy.lessons.lesson_13;

import java.io.Closeable;
import java.io.IOException;

public class Autocloseable implements Closeable {

	@Override
	public void close() throws IOException {
		System.out.println("Closing");
	}

}
