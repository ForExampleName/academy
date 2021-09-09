package by.academy.lessons.lesson_17;

public class DifferentThreadDemo {

	public static void f() {
		for (int i = 0; i <= 100; i++) {
			if (i % 10 == 0 && i != 0) {
				System.out.println(i);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Starting program");
		
		Thread threadUsingThreadObject = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i <= 100; i++) {
					if (i % 10 == 0 && i != 0) {
						System.out.println(i);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							System.err.println(e.getMessage());
						}
					}
				}
			}
		};

		System.out.println("Starting thread using Thread object");
		threadUsingThreadObject.start();
		try {
			threadUsingThreadObject.join();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}

		System.out.println("Thread ended");

		System.out.println("Starting thread using Runnable interface");

		Thread threadUsingRunnableIntf = new Thread(() -> { // we can use lambda because Runnable is functional
															// interface
			for (int i = 0; i <= 100; i++) {
				if (i % 10 == 0 && i != 0) {
					System.out.println(i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						System.err.println(e.getMessage());
					}
				}
			}
		});

		threadUsingRunnableIntf.start();
		try {
			threadUsingRunnableIntf.join();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Thread ended");
		System.out.println("Program ending.");
	}
}