package by.academy.lessons.lesson_9;

public class User {
	private String login;
	private String password;

	public User() {
		super();
	}

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

//Without static
//	class Query {
//		public void printToLog() {
//			System.out.println("User " + login + " was logined");
//		}
//	}

	static class Query {
		protected User user;

		public Query() {
			super();
		}

		public Query(User user) {
			this.user = user;
		}

		public void printToLog() {
			System.out.println("User " + user.login + " was logined");
		}
	}

//Without static
//	public void createQuery() {
//		new Query().printToLog();
//	}

	public void createQuery(User user) {
		new Query(user).printToLog();
	}
}