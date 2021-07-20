package by.academy.homeworks.homework_1;

public class Application {

	public static void main(String[] args) {
		Cat namelessCat = new Cat();
		Cat catBoris = new Cat("Boris");

		catBoris.sleep();
		catBoris.eat();
		catBoris.walk();

		for (int i = 0; i < 3; i++) {
			namelessCat.grow();
		}

		System.out.println("Nameless cat is " + namelessCat.getAge() + " years old.");
	}
}