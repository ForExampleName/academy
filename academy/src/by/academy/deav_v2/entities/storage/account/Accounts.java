package by.academy.deav_v2.entities.storage.account;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import by.academy.deav_v2.enums.Role;

public final class Accounts {
	private Database database;

	public Accounts() {
		super();
		database = new Database();

		database.loginInfo.put("SELLER", "SELLER");
		database.loginInfo.put("CUSTOMER", "CUSTOMER");

		database.userInfo.put("SELLER", new User("Николаев Игорь Юрьевич", LocalDate.of(1960, 1, 17), 10000.0D,
				"+375296900216", "vipem.zalubov@gmail.com", Role.SELLER));
		database.userInfo.put("CUSTOMER", new User("Мельница Любовь Анатольевна", LocalDate.of(1980, 2, 3), 15000.0D,
				"+375257788000", "melnica@mail.ru", Role.CUSTOMER));

		System.out.println(database.loginInfo);
		System.out.println(database.userInfo);
	}

	public Accounts(Database database) {
		super();
		this.database = database;
	}

	public boolean authentification(String login, String password) {
		return database.loginInfo.containsKey(login) && database.loginInfo.get(login).equals(password);
	}

	public User authorization(String login) {
		return database.userInfo.get(login);
	}

	public User getSeller() {
		return database.userInfo.get("SELLER");
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	@Override
	public int hashCode() {
		return Objects.hash(database);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounts other = (Accounts) obj;
		return Objects.equals(database, other.database);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Accounts [database=");
		builder.append(database);
		builder.append("]");
		return builder.toString();
	}

	private class Database {
		Map<String, String> loginInfo;
		Map<String, User> userInfo;

		public Database() {
			super();
			loginInfo = new HashMap<>();
			userInfo = new HashMap<>();
		}

		private Accounts getEnclosingInstance() {
			return Accounts.this;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(loginInfo, userInfo);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Database other = (Database) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(loginInfo, other.loginInfo) && Objects.equals(userInfo, other.userInfo);
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Database [loginInfo=");
			builder.append(loginInfo);
			builder.append(", userInfo=");
			builder.append(userInfo);
			builder.append("]");
			return builder.toString();
		}
	}
}