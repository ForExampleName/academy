package by.academy.lessons.lesson_16;

import java.util.Objects;

public class Cat {
	public String name = "Cat";
	protected String kingdom = "Animals";
	private int id = 1;

	public Cat() {
		super();
	}

	public Cat(String name, String kingdom, int id) {
		super();
		this.name = name;
		this.kingdom = kingdom;
		this.id = id;
	}

	@ToReadAnnotation
	public void voice() {
		System.out.println("Myaow");
	}

	protected void jump() {
		System.out.println("Jump");
	}

	private void call() {
		voice();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKingdom() {
		return kingdom;
	}

	public void setKingdom(String kingdom) {
		this.kingdom = kingdom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, kingdom, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return id == other.id && Objects.equals(kingdom, other.kingdom) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cat [name=");
		builder.append(name);
		builder.append(", kingdom=");
		builder.append(kingdom);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
}