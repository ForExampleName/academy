package by.academy.lessons.lesson_12.authentification;

public class WrongLoginException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public WrongLoginException() {
		super();
	}
	
	public WrongLoginException(String message) {
		super(message);
	}
}