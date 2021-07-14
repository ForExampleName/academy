package by.academy.homeworks.homework_2;

import java.util.Scanner;

public class SwitchCaseDemo {

	private static final String INT_TYPE = "int";
	private static final String DOUBLE_TYPE = "double";
	private static final String FLOAT_TYPE = "float";
	private static final String CHAR_TYPE = "char";
	private static final String STRING_TYPE = "String";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter type: ");
		String type = scanner.nextLine();

		switch (type) {
		case INT_TYPE:
			int intVar = scanner.nextInt();
			System.out.print(intVar % 2);
			break;
		case DOUBLE_TYPE:
			double doubleVar = scanner.nextDouble();
			System.out.print(doubleVar * 0.7);
			break;
		case FLOAT_TYPE:
			float floatVar = scanner.nextFloat();
			System.out.print(floatVar * floatVar);
			break;
		case CHAR_TYPE:
			char charVar = scanner.nextLine().charAt(0);
			System.out.print((int) charVar);
			break;
		case STRING_TYPE:
			String stringVar = scanner.nextLine();
			System.out.print("Hello " + stringVar);
			break;
		default:
			System.out.println("\nUnsupported type");
		}

		scanner.close();

	}

}
