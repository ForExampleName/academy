package by.academy.homeworks.homework_7;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class ReflectionDemo {

	public static void main(String[] args) {
		User testUser = new User("Иван", "Сидоров", 30, LocalDate.of(1991, 6, 21), "user1", "password1", "email@email");

		Class<User> clz = User.class;

		try {
			Method printUserInfoMethod = clz.getMethod("printUserInfo");
			System.out.println(printUserInfoMethod.getName());
		} catch (NoSuchMethodException e) {
			System.err.println("Данный метод не найден");
		} catch (SecurityException e) {
			System.err.println("Доступ закрыт");
		}

		System.out.println();

		for (Method m : clz.getMethods()) {
			System.out.println(m.getName());
		}

		System.out.println();

		try {
			Field passwordField = clz.getField("email");
			System.out.println(passwordField.getName());
		} catch (NoSuchFieldException e) {
			System.err.println("Данное поле не найдено");
		} catch (SecurityException e) {
			System.err.println("Доступ закрыт");
		}

		System.out.println();

		for (Field f : clz.getFields()) {
			System.out.println(f.getName());
		}

		System.out.println();

		try {
			Method printUserInfoMethod = clz.getDeclaredMethod("printUserInfo");
			System.out.println(printUserInfoMethod.getName());
		} catch (NoSuchMethodException e) {
			System.err.println("Данный метод не найден");
		} catch (SecurityException e) {
			System.err.println("Доступ закрыт");
		}

		System.out.println();

		for (Method m : clz.getDeclaredMethods()) {
			System.out.println(m.getName());
		}

		System.out.println();

		try {
			Field passwordField = clz.getDeclaredField("email");
			System.out.println(passwordField.getName());
		} catch (NoSuchFieldException e) {
			System.err.println("Данное поле не найдено");
		} catch (SecurityException e) {
			System.err.println("Доступ закрыт");
		}

		System.out.println();

		for (Field f : clz.getDeclaredFields()) {
			System.out.println(f.getName());
		}

		System.out.println();

		for (Field f : clz.getDeclaredFields()) {
			if (!f.canAccess(testUser)) {
				f.setAccessible(true);
			}

			try {
				f.set(testUser, "testValue");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				System.err.println(e.getMessage());
			}
		}

		for (Field f : clz.getDeclaredFields()) {
			try {
				System.out.println(f.get(testUser));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				System.err.println(e.getMessage());
			}
		}

		System.out.println();

		try {
			Method toString = clz.getMethod("toString");
			System.out.println(toString.invoke(testUser));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			System.err.println(e.getMessage());
		}
	}
}