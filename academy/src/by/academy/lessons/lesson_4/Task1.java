package by.academy.lessons.lesson_4;

public class Task1 {

	public static void main(String[] args) {
		String someString = "Some string that contain classes String, StringBuilder, StringBuffer";

		int index = 0;

//		while (index != -1) {
//			index = someString.indexOf("S", index);
//			if (index >= 0)
//				System.out.println(index++);
//		}

		do {
			index = someString.indexOf("S", index);
			if (index >= 0)
				System.out.println(index++);
		} while (index != -1);
	}
}
