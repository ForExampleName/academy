package by.academy.homeworks.homework_1;

public class Animal {
	private short age;
	private float weight;
	private String name;
	
	public Animal() {
		super();
		this.age = 0;
		this.weight = 0F;
		this.name = new String();	
	}
	
//	public Animal(short age) {
//		super();
//		this.age = age;
//		this.weight = 0F;
//		this.name = new String();	
//	}
//
//	public Animal(String name) {
//		super();
//		this.age = 0;
//		this.weight = 0F;
//		this.name = name;
//	}
//
//	public Animal(float weight) {
//		super();
//		this.age = 0;
//		this.weight = weight;
//		this.name = new String();
//	}
//
//	public Animal(short age, String name) {
//		super();
//		this.age = age;
//		this.weight = 0F;
//		this.name = name;
//	}
//
//	public Animal(float weight, String name) {
//		super();
//		this.age = 0;
//		this.weight = weight;
//		this.name = name;
//	}
//
//	public Animal(short age, float weight) {
//		super();
//		this.age = age;
//		this.weight = weight;
//		this.name = new String();
//	}

	public Animal(short age, float weight, String name) {
		super();
		this.age = age;
		this.name = name;
		this.weight = weight;
	}

	public short getAge() {
		return age;
	}
	public void setAge(short age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Animal [age=" + age + ", weight=" + weight + ", name=" + name + "]";
	}
}
