package by.academy.homeworks.homework_3.deal;

import java.time.LocalDate;
import java.util.Scanner;

import by.academy.homeworks.homework_3.deal.enums.Color;
import by.academy.homeworks.homework_3.deal.enums.Resolution;
import by.academy.homeworks.homework_3.deal.enums.Role;

public class Market {
	private static final Scanner scanner = new Scanner(System.in);

	private static final String SELLER_LOGIN = new String("SELLER");
	private static final String CUSTOMER_LOGIN = new String("CUSTOMER");

	private static final String SELLER_PASSWORD = new String("SELLER");
	private static final String CUSTOMER_PASSWORD = new String("CUSTOMER");

	private static Product[] catalog = new Product[7];
	private static User[] users = new User[2];
	private static Deal[] deals;

	static {
		catalog[0] = new MobilePhone("Samsung", 1800.0D, 2, "Galaxy S20", Color.BLACK, 12.0F);
		catalog[1] = new MobilePhone("Samsung", 3700.0D, 1, "Galaxy S21", Color.WHITE, 108.0F);
		catalog[2] = new MobilePhone("Apple", 2900.0D, 1, "iPhone 12 Pro", Color.BLUE, 12.0F);
		catalog[3] = new TV("Samsung", 2200.0D, 3, "QE55Q77TAU", 55.0F, Resolution.UHD);
		catalog[4] = new TV("LG", 1900.0D, 3, "55UP78006LC", 55.0F, Resolution.UHD);
		catalog[5] = new Laptop("ASUS", 2600.0D, 2, "ROG Strix G15", 2900, 16);
		catalog[6] = new Laptop("Apple", 2900.0D, 1, "Macbook Air 13", 2900, 8);

		users[0] = new User("Николаев Игорь Юрьевич", LocalDate.of(1960, 1, 17), 10000.0D, "+375296900216",
				"vipem.zalubov@gmail.com", Role.SELLER);
		users[1] = new User("Мельница Любовь Анатольевна", LocalDate.of(1980, 2, 3), 15000.0D, "+375257788000",
				"melnica@mail.ru", Role.CUSTOMER);
	}

	private static void addProductToCatalog(Product newProduct) {
		for (Product p : catalog) {
			if (p.equals(newProduct)) {
				p.setQuantity(p.getQuantity() + newProduct.getQuantity());
				return;
			}
		}

		Product[] newCatalog = new Product[catalog.length + 1];
		System.arraycopy(catalog, 0, newCatalog, 0, catalog.length);
		newCatalog[catalog.length] = newProduct;
		catalog = newCatalog;
	}

	public static void main(String[] args) {

		String input;
		int menu;
		User currentUser;
		
		while (true) {

			String login, password;

//			login: while (true) {
//				System.out.print("Логин: ");
//				login = scanner.nextLine();
//
//				System.out.print("Пароль: ");
//				password = scanner.nextLine();
//
//				if (login.equals(SELLER_LOGIN)) {
//					if (password.equals(SELLER_PASSWORD)) {
//						currentUser = users[0];
//						break;
//					}
//				} else if (login.equals(CUSTOMER_LOGIN)) {
//					if (password.equals(CUSTOMER_PASSWORD)) {
//						currentUser = users[1];
//						break;
//					}
//				}
//			}

			//// !!!!!!!!!!!!!!!!!!!!!!!!!
			currentUser = users[0];

			do {
				System.out.println("Главное меню");
				System.out.println("1. Сделки");
				System.out.println("2. Профиль");
				if (currentUser.getRole().equals(Role.SELLER))
					System.out.println("3. Каталог");
				System.out.print("0. Выход\n>");
				menu = scanner.nextInt();
			} while (currentUser.getRole().equals(Role.SELLER) ? (menu < 0 || menu > 3) : (menu < 0 && menu > 2));

			if (menu == 0) {
				break;
			}

			switch (menu) {
			// Deals
			case 1:
				if (currentUser.getRole().equals(Role.SELLER)) {

				} else if (currentUser.getRole().equals(Role.CUSTOMER)) {

				}

				break;
			// Profile
			case 2:
				int profileMenu;
				System.out.println(currentUser.getUserDescription());
				do {
					System.out.println("1. Изменить ФИО");
					System.out.println("2. Изменить номер мобильного телефона");
					System.out.println("3. Изменить адрес электронной почты");
					System.out.print("0. Главное меню\n>");

					profileMenu = scanner.nextInt();
				} while (profileMenu < 0 || profileMenu > 3);

				scanner.nextLine();

				if (profileMenu == 1) {
					System.out.print("Вводите ФИО: ");
					String fio = scanner.nextLine();

					currentUser.setFullName(fio);

				} else if (profileMenu == 2) {
					String phone;

					do {
						System.out.print("Вводите номер мобильного телефона: ");
						phone = scanner.nextLine();
					} while (!currentUser.setPhone(phone));

				} else if (profileMenu == 3) {
					String email;

					do {
						System.out.print("Вводите адрес электронной почты: ");
						email = scanner.nextLine();
					} while (!currentUser.setEmail(email));

				}

				break;
			// Catalog
			case 3:
				int catalogMenu;

				while (true) {
					do {
						System.out.println("1. Показать каталог");
						System.out.println("2. Добавить товар");
						System.out.print("0. Главное меню\n>");

						catalogMenu = scanner.nextInt();
					} while (catalogMenu < 0 || catalogMenu > 2);

					if (catalogMenu == 1) {
						for (Product p : catalog) {
							System.out.println(p.getDescription());
						}
					} else if (catalogMenu == 2) {
						int productID;
						do {
							System.out.println("1. Ноутбук");
							System.out.println("2. Мобильный телефон");
							System.out.print("3. Телевизор\n>");

							productID = scanner.nextInt();
						} while (productID < 1 || productID > 3);
						scanner.nextLine();
						
						String name, model;
						double price;
						int quantity;

						if (productID == 1) {
							int processor, ram;
							System.out.print("Введите название: ");
							name = scanner.nextLine();

							System.out.print("Введите название модели: ");
							model = scanner.nextLine();

							System.out.print("Введите количество товара: ");
							quantity = scanner.nextInt();

							System.out.print("Введите цену: ");
							price = scanner.nextDouble();

							System.out.print("Введите частоту процессора(МГц): ");
							processor = scanner.nextInt();

							System.out.print("Введите количество ОЗУ: ");
							ram = scanner.nextInt();

							addProductToCatalog(new Laptop(name, price, quantity, model, processor, ram));
						} else if (productID == 2) {
							Color color;
							float camera;

							System.out.print("Введите название: ");
							name = scanner.nextLine();

							System.out.print("Введите название модели: ");
							model = scanner.nextLine();

							System.out.print("Введите количество товара: ");
							quantity = scanner.nextInt();

							System.out.print("Введите цену: ");
							price = scanner.nextDouble();

							System.out.print("Введите цвет. Возможные цвета: ");
							for (Color c : Color.values()) {
								System.out.print(c + "|");
							}
							System.out.print("\n>");

							color = Color.getColorByName(scanner.nextLine());

							System.out.print("Введите количество МП камеры: ");
							camera = scanner.nextFloat();

							addProductToCatalog(new MobilePhone(name, price, quantity, model, color, camera));
						} else if (productID == 3) {
							Resolution resolution;
							float diagonal;

							System.out.print("Введите название: ");
							name = scanner.nextLine();

							System.out.print("Введите название модели: ");
							model = scanner.nextLine();

							System.out.print("Введите количество товара: ");
							quantity = scanner.nextInt();

							System.out.print("Введите цену: ");
							price = scanner.nextDouble();

							System.out.print("Введите разрешение экрана. Возможные варианты: ");
							for (Resolution r : Resolution.values()) {
								System.out.print(r + "|");
							}
							System.out.print("\n>");

							resolution = Resolution.getResolutionByName(scanner.nextLine());

							System.out.print("Введите диагональ экрана: ");
							diagonal = scanner.nextFloat();

							addProductToCatalog(new TV(name, price, quantity, model, diagonal, resolution));
						}
					} else if (catalogMenu == 0) {
						break;
					}
				}

			}
			scanner.nextLine();
		}

		scanner.close();
	}
}