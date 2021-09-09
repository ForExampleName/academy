package by.academy.lessons.lesson_17;

import java.util.Arrays;

public class RunnableDemo {

	public static void main(String[] args) {
		Runnable min = new Runnable1();
		System.out.println(Arrays.toString(((Runnable1) min).getNums()));

		Thread minThread = new Thread(min);
		minThread.start();

		try {
			minThread.join();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}

		Runnable max = new Runnable2();
		System.out.println(Arrays.toString(((Runnable2) max).getNums()));

		Thread maxThread = new Thread(max);
		maxThread.start();

		try {
			maxThread.join();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}

		Runnable avg = new Runnable3();
		System.out.println(Arrays.toString(((Runnable3) avg).getNums()));

		Thread avgThread = new Thread(avg);
		avgThread.start();

		try {
			avgThread.join();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
}