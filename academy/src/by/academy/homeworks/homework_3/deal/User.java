package by.academy.homeworks.homework_3.deal;

import java.time.LocalDate;
import java.util.Objects;

import by.academy.homeworks.homework_3.deal.enums.Role;
import by.academy.homeworks.homework_3.validators.AmericanPhoneValidator;
import by.academy.homeworks.homework_3.validators.BelarusPhoneValidator;
import by.academy.homeworks.homework_3.validators.EmailValidator;

public class User {
	protected String fullName;
	protected LocalDate birthday;
	protected double money;
	protected String phone;
	protected String email;
	protected Role role;

	public User() {
		super();
	}

	public User(String fullName, LocalDate birthday, double money, String phone, String email, Role role) {
		super();
		this.fullName = fullName;
		this.birthday = birthday;
		this.money = money;
		this.phone = phone;
		this.email = email;
		this.role = role;
	}

	public String getUserDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append(role.equals(Role.SELLER) ? "Продавец: " : "Клиент: ");
		builder.append(fullName);
		builder.append("\nТелефон: ");
		builder.append(phone);
		builder.append("\nE-mail: ");
		builder.append(email);
		return builder.toString();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getPhone() {
		return phone;
	}

	public boolean setPhone(String phone) {
		if (new BelarusPhoneValidator().validate(phone) || new AmericanPhoneValidator().validate(phone)) {
			this.phone = phone;
			return true;
		}

		System.out.println("Не соответствует формату");
		return false;
	}

	public String getEmail() {
		return email;
	}

	public boolean setEmail(String email) {
		if (new EmailValidator().validate(email)) {
			this.email = email;
			return true;
		}

		System.out.println("Не соответствует формату");
		return false;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthday, email, fullName, money, phone, role);
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
		return Objects.equals(birthday, other.birthday) && Objects.equals(email, other.email)
				&& Objects.equals(fullName, other.fullName)
				&& Double.doubleToLongBits(money) == Double.doubleToLongBits(other.money)
				&& Objects.equals(phone, other.phone) && role == other.role;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [fullName=");
		builder.append(fullName);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", money=");
		builder.append(money);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}
}