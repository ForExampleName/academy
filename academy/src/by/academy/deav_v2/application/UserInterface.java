package by.academy.deav_v2.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import by.academy.deav_v2.description.DescriptionProvider;
import by.academy.deav_v2.entities.deal.Deal;
import by.academy.deav_v2.entities.deal.DealList;
import by.academy.deav_v2.entities.products.Product;
import by.academy.deav_v2.entities.storage.account.Accounts;
import by.academy.deav_v2.entities.storage.account.User;
import by.academy.deav_v2.enums.Color;
import by.academy.deav_v2.enums.Resolution;
import by.academy.deav_v2.enums.Role;
import by.academy.homeworks.homework_3.validators.AmericanPhoneValidator;
import by.academy.homeworks.homework_3.validators.BelarusPhoneValidator;
import by.academy.homeworks.homework_3.validators.DateValidator;
import by.academy.homeworks.homework_3.validators.EmailValidator;

public final class UserInterface {
	private Scanner scanner = new Scanner(System.in);
	public static final int MENU_DEFAULT_VALUE = -1;
	public static final int MENU_EXIT = 0;

	public static final int MAIN_MENU_DEALS = 1;
	public static final int MAIN_MENU_PROFILE = 2;
	public static final int MAIN_MENU_CATALOG = 3;

	public static final int DEALS_MENU_SELLER_SHOW = 1;
	public static final int DEALS_MENU_SELLER_COMPLETE = 2;

	public static final int DEALS_MENU_CUSTOMER_READ = 1;
	public static final int DEALS_MENU_CUSTOMER_CREATE = 2;
	public static final int DEALS_MENU_CUSTOMER_UPDATE = 3;
	public static final int DEALS_MENU_CUSTOMER_DELETE = 4;

	public static final int NEW_DEAL_MENU_ADD_PRODUCT = 1;

	public static final int UPDATE_DEAL_MENU_ADD_PRODUCT = 1;
	public static final int UPDATE_DEAL_MENU_REMOVE_PRODUCT = 2;

	public static final int PROFILE_MENU_CHANGE_FIO = 1;
	public static final int PROFILE_MENU_CHANGE_PHONE = 2;
	public static final int PROFILE_MENU_CHANGE_EMAIL = 3;
	public static final int PROFILE_MENU_CHANGE_BIRTHDAY = 4;

	public static final int CATALOG_MENU_ADD_PRODUCT = 1;
	public static final int CATALOG_MENU_SHOW = 2;

	public static final int LAPTOP_ID = 1;
	public static final int PHONE_ID = 2;
	public static final int TV_ID = 3;

	public UserInterface() {
		super();
	}

	public boolean programContinue() {
		System.out.println("Выйти из программы?(да/нет)");

		if (scanner.nextLine().equals("да")) {
			return false;
		}

		return true;
	}

	public User login(Accounts accounts) {
		String login, password;

		System.out.print("Логин: ");
		login = scanner.nextLine();

		System.out.print("Пароль: ");
		password = scanner.nextLine();

		if (!accounts.authentification(login, password)) {
			System.out.println("Доступ запрещён. Неправильный логин или пароль");
			return null;
		}

		return accounts.authorization(login);
	}

	public int mainMenu() {
		int input;

		System.out.println("Главное меню");
		System.out.println("1. Сделки");
		System.out.println("2. Профиль");
		System.out.println("3. Каталог");
		System.out.println("0. Выход из учётной записи");

		do {
			System.out.print(">");
			input = scanner.nextInt();
			scanner.nextLine();
		} while (input < 0 || input > 3);

		return input;
	}

	public int dealsMenu(Role role) {
		int input = 0;

		switch (role) {
		case SELLER:
			System.out.println("1. Показать сделки");
			System.out.println("2. Осуществить сделку");
			System.out.println("0. Главное меню");

			do {
				System.out.print(">");
				input = scanner.nextInt();
				scanner.nextLine();
			} while (input < 0 || input > 2);

			break;
		case CUSTOMER:
			System.out.println("1. Показать сделки");
			System.out.println("2. Добавить сделку");
			System.out.println("3. Изменить сделку");
			System.out.println("4. Отменить сделку");
			System.out.println("0. Главное меню");

			do {
				System.out.print(">");
				input = scanner.nextInt();
				scanner.nextLine();
			} while (input < 0 || input > 4);
		}

		return input;
	}

	public void showDeals(DealList deals) {
		if (deals.isEmpty()) {
			System.out.println("Список сделок пуст.");
			return;
		} else {
			System.out.println(deals.getAllDealsDescription());
		}
	}

	public int dealNumberInput(int limit) {
		int input;

		System.out.println("Введите номер сделки");

		do {
			System.out.print(">");
			input = scanner.nextInt();
			scanner.nextLine();
		} while (input < 1 || input >= limit);

		return input - 1;
	}

	public void printBill(Deal deal) {
		System.out.println(deal.getBill());
	}

	public void removeDeal(int index) {
		System.out.println("Сделка " + (index + 1) + " была отменена");
	}

	public int newDealMenu(Deal deal) {
		int input;

		System.out.println("Текущий состав сделки:");
		System.out.println(deal.getProductsDescription());
		System.out.println("1. Добавить товар в сделку");
		System.out.println("0. Готово");

		do {
			System.out.print(">");
			input = scanner.nextInt();
			scanner.nextLine();
		} while (input < 0 || input > 1);

		return input;
	}

	private void showProductList(List<Product> products) {
		for (int i = 0; i < products.size(); i++) {
			System.out.println((i + 1) + ". " + DescriptionProvider.getDescription(products.get(i)));
		}
	}

	public void showCatalog(List<Product> catalog) {
		System.out.println("Каталог:");
		showProductList(catalog);
	}

	public void showDealProducts(Deal deal) {
		System.out.println("Корзина сделки:");
		showProductList(deal.getProducts());
	}

	public void showRestOfMoney(User user) {
		System.out.println("Остаток средств: " + user.getMoney() + "\n");
	}

	public Product productInput(List<Product> products) {
		String input;
		int productIndx, quantity;

		System.out.print("Введите через пробел номер товара и количество\n");
		while (true) {
			System.out.print(">");
			input = scanner.nextLine();

			productIndx = Integer.valueOf(input.split(" ")[0]);
			quantity = Integer.valueOf(input.split(" ")[1]);

			if (productIndx < 1 || productIndx > products.size()) {
				System.out.println("Не верный номер товара");
				continue;
			}

			Product currentProduct = null;
			try {
				currentProduct = products.get(productIndx - 1).clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}

			if (quantity > currentProduct.getQuantity()) {
				System.out.println("Указанное количество товара больше, чем имеется в списке");
				continue;
			}

			currentProduct.setQuantity(quantity);
			return currentProduct;
		}
	}

	public void emptyCatalog() {
		System.out.println("Извините, в данное время каталог пуст");
	}

	public void cancelDeal() {
		System.out.println("Создание сделки отменено");
	}

	public void dealSaved() {
		System.out.println("Сделка сохранена в текущем виде");
	}

	public void makeDeal() {
		System.out.println("Сделка успешно создана");
	}

	public int changeDealMenu() {
		int input;

		System.out.println("Выберите действие:");
		System.out.println("1. Убрать товар");
		System.out.println("2. Добавить товар");

		do {
			System.out.print(">");
			input = scanner.nextInt();
			scanner.nextLine();
		} while (input < 1 || input > 2);

		return input;
	}

	public int profileMenu(User user) {
		int input;

		System.out.println("Профиль\n" + user.getUserDescription());
		System.out.println("1. Изменить ФИО");
		System.out.println("2. Изменить номер мобильного телефона");
		System.out.println("3. Изменить адрес электронной почты");
		System.out.println("4. Изменить день рождения");
		System.out.print("0. Главное меню");

		do {
			System.out.print("\n>");
			input = scanner.nextInt();
			scanner.nextLine();
		} while (input < 0 || input > 4);

		return input;
	}

	public String fioInput() {
		System.out.print("Введите ФИО: ");
		return scanner.nextLine();
	}

	public String phoneInput() {
		String phone;

		System.out.print("Введите номер мобильного телефона: ");
		do {
			phone = scanner.nextLine();
		} while (!(new BelarusPhoneValidator().validate(phone) || new AmericanPhoneValidator().validate(phone)));

		return phone;
	}

	public String emailInput() {
		String email;

		System.out.print("Введите адрес электронной почты: ");
		do {
			email = scanner.nextLine();
		} while (!(new EmailValidator().validate(email)));

		return email;
	}

	public LocalDate birthdayInput() {
		String birthday;

		System.out.print("Введите дату Вашего дня рождения (формат: dd/MM/yyyy): ");
		do {
			birthday = scanner.nextLine();
		} while (!(new DateValidator().validate(birthday)));

		return LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public int catalogMenu(Role role) {
		int input;

		System.out.println("1. Показать каталог");
		if (role.equals(Role.SELLER))
			System.out.println("2. Добавить товар");
		System.out.println("0. Главное меню");
		do {
			System.out.print(">");
			input = scanner.nextInt();
			scanner.nextLine();
		} while (role.equals(Role.SELLER) ? (input < 0 || input > 2) : (input < 0 || input > 1));

		return input;
	}

	public int productIdInput() {
		int input;

		System.out.println("1. Ноутбук");
		System.out.println("2. Мобильный телефон");
		System.out.println("3. Телевизор");

		do {
			System.out.print(">");
			input = scanner.nextInt();
			scanner.nextLine();
		} while (input < 1 || input > 3);

		return input;
	}

	public String productNameInput() {
		System.out.print("Введите название товара: ");
		return scanner.nextLine();
	}

	public String productModelInput() {
		System.out.print("Введите название модели: ");
		return scanner.nextLine();
	}

	public double productPriceInput() {
		System.out.print("Введите цену: ");
		return scanner.nextDouble();
	}

	public int productQuantityInput() {
		System.out.print("Введите количество товара: ");
		return scanner.nextInt();
	}

	public int processorInput() {
		System.out.print("Введите частоту процессора(МГц): ");
		return scanner.nextInt();
	}

	public int ramInput() {
		System.out.print("Введите количество ОЗУ: ");
		return scanner.nextInt();
	}

	public Color colorInput() {
		Color color;

		System.out.println("Введите цвет. Возможные цвета: ");
		for (Color c : Color.values()) {
			System.out.println(c.getName());
		}

		do {
			System.out.print(">");
			color = Color.getColorByName(scanner.nextLine());
		} while (color == null);

		return color;
	}

	public float cameraInput() {
		System.out.print("Введите количество МП камеры: ");
		return scanner.nextFloat();
	}

	public Resolution resolutionInput() {
		Resolution resolution;

		System.out.println("Введите разрешение экрана. Возможные варианты: ");
		for (Resolution r : Resolution.values()) {
			System.out.println(r.getName());
		}

		do {
			System.out.print(">");
			resolution = Resolution.getResolutionByName(scanner.nextLine());
		} while (resolution == null);

		return resolution;
	}

	public float diagonalInput() {
		System.out.print("Введите диагональ экрана: ");
		return scanner.nextFloat();
	}
}