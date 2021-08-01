package by.academy.lessons.lesson_8.task1;

public class Magazine implements Printable {
	public Magazine() {
		super();
	}

	public static void printMagazines(Printable[] printable) {
		for(Printable p: printable) {
			if(p instanceof Magazine) {
				p.print();
			}
		}
	}
	
	@Override
	public void print() {
		System.out.println("This is magazine");
	}
}