package by.academy.lessons.lesson_8.task1;

public class Main {

	public static void main(String[] args) {
		Printable[] printables = new Printable[10];
		
		for(int i=0;i<printables.length;i++) {
			if(i%2==0) {
				printables[i] = new Book();
			}
			else {
				printables[i] = new Magazine();
			}
		}
		
		for(Printable p: printables) {
			p.print();
		}
		
		System.out.println("\n\n\n");
		
		Magazine.printMagazines(printables);
		
		Book.printBooks(printables);
	}
}