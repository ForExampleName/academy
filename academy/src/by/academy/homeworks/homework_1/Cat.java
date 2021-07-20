package by.academy.homeworks.homework_1;

import java.util.Objects;

public class Cat {
	private int age;
	private String nickname;
	private float money;
	private char initials;
	private boolean isHomeAnimal;

	public Cat() {
	}

	public Cat(String nickname) {
		this.nickname = nickname;
		if (nickname != null)
			this.initials = nickname.charAt(0);
	}

	public void grow() {
		this.age += 1;
	}

	public void sleep() {
		System.out.println("ZzZ... Cat " + ((nickname == null) ? "" : (nickname + " ")) + "is sleeping ...ZzZ");
	}

	public void eat() {
		System.out.println("Cat " + ((nickname == null) ? "" : (nickname + " ")) + "is eating");
	}

	public void walk() {
		System.out.println("Cat " + ((nickname == null) ? "" : (nickname + " ")) + "is walking");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public char getInitials() {
		return initials;
	}

	public void setInitials(char initials) {
		this.initials = initials;
	}

	public boolean isHomeAnimal() {
		return isHomeAnimal;
	}

	public void setHomeAnimal(boolean isHomeAnimal) {
		this.isHomeAnimal = isHomeAnimal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, initials, isHomeAnimal, money, nickname);
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
		return age == other.age && initials == other.initials && isHomeAnimal == other.isHomeAnimal
				&& Float.floatToIntBits(money) == Float.floatToIntBits(other.money)
				&& Objects.equals(nickname, other.nickname);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cat [age=");
		sb.append(age);
		sb.append(", nickname=");
		sb.append((nickname == null) ? "Doesn't have name" : nickname);
		sb.append(", money=");
		sb.append(money);
		sb.append(", initials=");
		sb.append(((int) initials == 0) ? "Doesn't have initials" : initials);
		sb.append(", isHomeAnimal=");
		sb.append(isHomeAnimal);
		sb.append("]");
		return sb.toString();
	}
}