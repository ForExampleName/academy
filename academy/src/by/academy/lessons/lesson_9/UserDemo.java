package by.academy.lessons.lesson_9;

public class UserDemo {

	public static void main(String[] args) {
		User user = new User("Hacker", "12345");
//		user.createQuery();

//Without static
//		User.Query query = new User().new Query();
//		query.printToLog();
//
//		User.Query queryCreatedUsingExistingUser = user.new Query();
//		queryCreatedUsingExistingUser.printToLog();

		user.createQuery(user);
		User.Query query = new User.Query(user);
		query.printToLog();
	}
}