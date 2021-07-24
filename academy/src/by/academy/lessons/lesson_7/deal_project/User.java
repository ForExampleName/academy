package by.academy.lessons.lesson_7.deal_project;

import java.util.Objects;

public class User {
	private String fullName;
	private double money;

	public User() {
		super();
	}

	public User(String fullName, double money) {
		super();
		this.fullName = fullName;
		this.money = money;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fullName, money);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(fullName, other.fullName)
				&& Double.doubleToLongBits(money) == Double.doubleToLongBits(other.money);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("User [fullName=");
		sb.append(fullName);
		sb.append(", money=");
		sb.append(money);
		sb.append("]");
		return sb.toString();
	}
}