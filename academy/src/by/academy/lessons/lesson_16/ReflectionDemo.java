package by.academy.lessons.lesson_16;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionDemo {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Tiger tiger = new Tiger();

		System.out.println(cat.getClass().getName() + " class methods:");
		for (Method m : cat.getClass().getDeclaredMethods()) {
			System.out.println(m.getName());
		}

		System.out.println(tiger.getClass().getName() + " class methods:");
		for (Method m : tiger.getClass().getDeclaredMethods()) {
			System.out.println(m.getName());
		}

		System.out.println(cat.getClass().getName() + " class fields:");
		for (Field f : cat.getClass().getDeclaredFields()) {
			System.out.println(f.getName());
		}

		System.out.println(tiger.getClass().getName() + " class fields:");
		for (Field f : tiger.getClass().getDeclaredFields()) {
			System.out.println(f.getName());
		}

		System.out.println("Changing cat private field id: 1->10");
		try {
			Field catPrivateField = cat.getClass().getDeclaredField("id");
			catPrivateField.setAccessible(true);
			catPrivateField.set(cat, 10);
			System.out.println(catPrivateField.get(cat));
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		System.out.println("Changing tiger public field name: Tiger->TIGER");
		try {
			Field tigerPublicField = tiger.getClass().getDeclaredField("name");// tiger to car
			tigerPublicField.set(tiger, "TIGER");
			System.out.println(tigerPublicField.get(tiger));// prints changed
//			System.out.println(tiger.getName());//prints same
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		System.out.println("Try to invoke tiger private method\"run\"");
		try {
			Method tigerPrivateMethodRun = tiger.getClass().getDeclaredMethod("run");
			tigerPrivateMethodRun.setAccessible(true);
			tigerPrivateMethodRun.invoke(tiger);
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
		}
		Integer.parseInt("1");
		
		try {
			for(Annotation a: cat.getClass().getDeclaredMethod("voice").getAnnotations()) {
				System.out.println(a);
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		try {
			for(Annotation a: tiger.getClass().getDeclaredMethod("voice").getAnnotations()) {
				System.out.println(a);
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

	}
}