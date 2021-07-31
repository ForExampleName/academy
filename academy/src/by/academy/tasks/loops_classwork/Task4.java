package by.academy.tasks.loops_classwork;

public class Task4 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<11;i++) {
			sb.append("Task");
			sb.append(i);
			System.out.println(sb.toString());
			sb.delete(0, sb.length());
		}
	}
}