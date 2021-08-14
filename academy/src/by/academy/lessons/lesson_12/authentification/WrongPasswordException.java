package by.academy.lessons.lesson_12.authentification;

public class WrongPasswordException extends Exception {
	private static final long serialVersionUID = 1L;

	public WrongPasswordException() {
		super();
	}

	public WrongPasswordException(String message) {
		super(message);
	}
}