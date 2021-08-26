package by.academy.lessons.lesson_14;

public class PrintableLambdaDemo {

	public static void main(String[] args) {
		Printable printableLambda = message -> System.out.println(message);
		printableLambda.print("Hello Lambda World!");
	}
}