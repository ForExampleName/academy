package by.academy.lessons.lesson_16;

import java.util.Objects;

public class Tiger extends Cat {
	public String name = "Tiger";
	protected String type = "Predator";
	private int id = 2;

	public Tiger() {
		super();
	}

	public Tiger(String catName, String kingdom, int catId, String tigerName, String type, int tigerId) {
		super(catName, kingdom, catId);
		name = tigerName;
		this.type = type;
		id = tigerId;
	}

	@Override
	@ToReadAnnotation
	public void voice() {
		System.out.println("RRRrrrrRrrrrr");
	}

	@Override
	protected void jump() {
		System.out.println("Long Jump");
	}

	private void call() {
		voice();
	}

	private void run() {
		System.out.println("Tiger running to you. Very fast. Very-Very FAST......");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id, name, type);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tiger other = (Tiger) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tiger [name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
}