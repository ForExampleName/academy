package by.academy.lessons.lesson_12.authentification;

import java.util.regex.Pattern;

public class AuthentificationDemo {
	private static final Pattern pattern = Pattern.compile("[a-zA-Z0-9_]{1,20}");

	private static boolean checkInfo(String login, String password, String confirmPassword)
			throws WrongLoginException, WrongPasswordException {
		if (login == null) {
			throw new WrongLoginException("Login is empty");
		}

		if (password == null) {
			throw new WrongPasswordException("Password is empty");
		}

		if (confirmPassword == null) {
			throw new WrongPasswordException("Confirming password is empty");
		}

		if (!pattern.matcher(login).matches())
			throw new WrongLoginException("Wrong characters in login or length > 20");

		if (!pattern.matcher(password).matches())
			throw new WrongPasswordException("Wrong characters in password or length > 20");

		if (!password.equals(confirmPassword))
			throw new WrongPasswordException("Passwords not equal");

		return true;
	}

	public static void main(String[] args) {
		String login = new String("Hacker");
		String password = new String("12345_67");
		String confirmPassword = new String("12345_67");

		boolean status = false;

		try {
			status = checkInfo(login, password, confirmPassword);
		} catch (WrongLoginException e) {
			System.out.println("Wrong login");
			System.out.println(e.getMessage());
		} catch (WrongPasswordException e) {
			System.out.println("Wrong password");
			System.out.println(e.getMessage());
		}

		System.out.println(status ? "Confirmed. User " + login + " was created" : "Not confirmed");
	}
}