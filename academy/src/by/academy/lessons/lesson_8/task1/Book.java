package by.academy.lessons.lesson_8.task1;

public class Book implements Printable {
	public Book() {
		super();
	}

	public static void printBooks(Printable[] printable) {
		for(Printable p: printable) {
			if(p instanceof Book) {
				p.print();
			}
		}
	}
	
	@Override
	public void print() {
		System.out.println("This is book");
	}
}