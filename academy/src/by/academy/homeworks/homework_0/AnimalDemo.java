package by.academy.homeworks.homework_0;

public class AnimalDemo {

	public static void main(String[] args) {
		Animal animal1 = new Animal();
		Animal animal2 = new Animal((short)5 , 130.8F, "Giraffe");
		System.out.println(animal1);
		System.out.println(animal2);
	}
}
