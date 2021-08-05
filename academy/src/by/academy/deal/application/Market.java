package by.academy.deal.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import by.academy.deal.Deal;
import by.academy.deal.User;
import by.academy.deal.entities.products.Laptop;
import by.academy.deal.entities.products.MobilePhone;
import by.academy.deal.entities.products.Product;
import by.academy.deal.entities.products.TV;
import by.academy.deal.enums.Color;
import by.academy.deal.enums.Resolution;
import by.academy.deal.enums.Role;
import by.academy.homeworks.homework_3.validators.AmericanPhoneValidator;
import by.academy.homeworks.homework_3.validators.BelarusPhoneValidator;
import by.academy.homeworks.homework_3.validators.DateValidator;
import by.academy.homeworks.homework_3.validators.EmailValidator;

public class Market {
	private static Scanner scanner = new Scanner(System.in);

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

	private static void showDeals(Deal[] deals) {
		if (deals == null) {
			System.out.println("Сделки отсутствуют");

		} else {
			for (int i = 0; i < deals.length; i++) {
				System.out.println("-------------------------------------------------------------");
				System.out.println("Сделка №" + (i + 1));
				System.out.println(deals[i].getBill());
				System.out.println("-------------------------------------------------------------");
			}
		}
	}

	public static void main(String[] args) {
		// testing deprecated mathod
		catalog[0].test();

		int mainMenu;

		String login, password;
		User currentUser;

		while (true) {

			System.out.println("Выйти из программы?(да/нет)");
			if (scanner.nextLine().equals("да")) {
				break;
			}

			while (true) {
				System.out.print("Логин(глобальная переменная): ");
				login = scanner.nextLine();

				System.out.print("Пароль(глобальная переменная): ");
				password = scanner.nextLine();

				if (login.equals(SELLER_LOGIN) && password.equals(SELLER_PASSWORD)) {
					currentUser = users[0];
					break;
				} else if (login.equals(CUSTOMER_LOGIN) && password.equals(CUSTOMER_PASSWORD)) {
					currentUser = users[1];
					break;
				}
			}

			while (true) {
				System.out.println("Главное меню");
				System.out.println("1. Сделки");
				System.out.println("2. Профиль");
				System.out.println("3. Каталог");
				System.out.println("0. Выход из учётной записи");

				do {
					System.out.print(">");
					mainMenu = scanner.nextInt();
					scanner.nextLine();
				} while (mainMenu < 0 || mainMenu > 3);

				if (mainMenu == 0) {
					break;
				}

				switch (mainMenu) {
				// Deals
				case 1:
					int dealsMenu;

					if (currentUser.getRole().equals(Role.SELLER)) {
						System.out.println("1. Показать сделки");
						System.out.println("2. Осуществить сделку");
						System.out.println("0. Главное меню");

						do {
							System.out.print(">");
							dealsMenu = scanner.nextInt();
							scanner.nextLine();
						} while (dealsMenu < 0 || dealsMenu > 2);

						if (dealsMenu == 1) {
							showDeals(deals);
						} else if (dealsMenu == 2) {
							showDeals(deals);

							if (deals == null) {
								continue;
							}

							int dealNumber;

							System.out.println("Введите номер сделки");

							do {
								System.out.print(">");
								dealNumber = scanner.nextInt();
								scanner.nextLine();
							} while (dealNumber < 1 || dealNumber > deals.length);

							users[0].setMoney(users[0].getMoney() + deals[dealNumber - 1].calcFullPrice());
							deals = Deal.removeDealFromArray(deals, dealNumber - 1);

						}
					} else if (currentUser.getRole().equals(Role.CUSTOMER)) {
						while (true) {
							System.out.println("1. Показать сделки");
							System.out.println("2. Добавить сделку");
							System.out.println("3. Изменить сделку");
							System.out.println("4. Отменить сделку");
							System.out.println("0. Главное меню");

							do {
								System.out.print(">");
								dealsMenu = scanner.nextInt();
								scanner.nextLine();
							} while (dealsMenu < 0 || dealsMenu > 4);

							if (dealsMenu == 0) {
								break;
							} else if (dealsMenu == 1 || dealsMenu == 4) {
								showDeals(deals);

								if (deals == null || dealsMenu == 1) {
									continue;
								}

								int dealNumber;

								System.out.println("Введите номер сделки");
								do {
									System.out.print(">");
									dealNumber = scanner.nextInt();
									scanner.nextLine();
								} while (dealNumber < 1 || dealNumber > deals.length);

								for (Product p : deals[dealNumber - 1].getProducts()) {
									catalog = Product.addProductToArray(catalog, p);
								}

								users[1].setMoney(users[1].getMoney() + deals[dealNumber - 1].calcFullPrice());

								deals = Deal.removeDealFromArray(deals, dealNumber - 1);
								System.out.println("Сделка " + dealNumber + " была отменена");

							} else if (dealsMenu == 2) {
								int menu;
								Deal deal = new Deal();

								while (true) {
									System.out.println("Текущий состав сделки:");
									System.out.println(deal.getProductsDescription());
									System.out.println("1. Добавить товар в сделку");
									System.out.println("0. Готово");

									do {
										System.out.print(">");
										menu = scanner.nextInt();
										scanner.nextLine();
									} while (menu < 0 || menu > 1);

									if (menu == 0) {
										break;
									} else if (menu == 1) {
										if (catalog.length == 0) {
											System.out.println("Извините, в данное время каталог пуст");
											if (deal.getProducts() == null)
												System.out.println("Создание сделки отменено");
											else
												System.out.println("Сделка сохранена в текущем виде");
											break;
										}

										String input;
										int productIndx, quantity;

										while (true) {
											System.out.println("Каталог:");

											for (int i = 0; i < catalog.length; i++) {
												System.out.println((i + 1) + ". " + catalog[i].getDescription());
											}

											System.out.println("Остаток средств: " + users[1].getMoney() + "\n");

											System.out.print("Введите через пробел номер товара и количество:");
											input = scanner.nextLine();

											productIndx = Integer.valueOf(input.split(" ")[0]);
											quantity = Integer.valueOf(input.split(" ")[1]);

											if (productIndx < 1 || productIndx > catalog.length) {
												continue;
											}

											Product currentProduct = null;
											try {
												currentProduct = catalog[productIndx - 1].clone();
											} catch (CloneNotSupportedException e) {
												e.printStackTrace();
											}

											if (quantity > currentProduct.getQuantity()) {
												System.out
														.println("Выбрано слишком большое значение количества товара");
												continue;
											}

											currentProduct.setQuantity(quantity);

											if (deal.addProductToDeal(users[1], currentProduct)) {
												catalog = Product.removeProductFromArray(catalog, currentProduct);
											}

											break;
										}
									}
								}

								if (deal.getProducts() != null) {
									deal.setCustomer(users[1]);
									deal.setSeller(users[0]);
									deal.setDealDate(LocalDate.now());

									deals = Deal.addDealToArray(deals, deal);

									System.out.println("Сделка успешно создана");
								}

							} else if (dealsMenu == 3) {
								int dealNumber, action;

								showDeals(deals);
								System.out.println("Выберите номер сделки");
								do {
									System.out.print(">");
									dealNumber = scanner.nextInt();
									scanner.nextLine();
								} while (dealNumber < 1 || dealNumber > deals.length);

								System.out.println("Выберите действие:");
								System.out.println("1. Убрать товар");
								System.out.println("2. Добавить товар");

								do {
									System.out.print(">");
									action = scanner.nextInt();
									scanner.nextLine();
								} while (action < 1 || action > 2);

								if (action == 1) {
									Product[] dealProducts = deals[dealNumber - 1].getProducts();
									for (int i = 0; i < dealProducts.length; i++) {
										System.out.println((i + 1) + ". " + dealProducts[i].getDescription());
									}

									String input;
									int productIndx, quantity;

									System.out.println("Введите через пробел номер товара и количество");
									while (true) {
										System.out.print("\n>");
										input = scanner.nextLine();

										productIndx = Integer.valueOf(input.split(" ")[0]);
										quantity = Integer.valueOf(input.split(" ")[1]);

										if (productIndx < 1 || productIndx > dealProducts.length) {
											System.out.println("Введён неправильный номер");
											continue;
										}

										if (quantity > dealProducts[productIndx - 1].getQuantity()) {
											System.out.println("Выбрано слишком большое значение количества товара");
											continue;
										}

										Product toRemove = null;

										try {
											toRemove = dealProducts[productIndx - 1].clone();
										} catch (CloneNotSupportedException e) {
											e.printStackTrace();
										}

										toRemove.setQuantity(quantity);

										deals[dealNumber - 1].removeProductFromDeal(users[1], toRemove);

										catalog = Product.addProductToArray(catalog, toRemove);
										break;
									}
								} else {
									System.out.println("Каталог");
									for (int i = 0; i < catalog.length; i++) {
										System.out.println((i + 1) + ". " + catalog[i].getDescription());
									}

									String input;
									int productIndx, quantity;

									System.out.println("Введите через пробел номер товара и количество");
									while (true) {
										System.out.print("\n>");
										input = scanner.nextLine();

										productIndx = Integer.valueOf(input.split(" ")[0]);
										quantity = Integer.valueOf(input.split(" ")[1]);

										if (productIndx < 1 || productIndx > catalog.length) {
											System.out.println("Введён неправильный номер");
											continue;
										}

										if (quantity > catalog[productIndx - 1].getQuantity()) {
											System.out.println("Выбрано слишком большое значение количества товара");
											continue;
										}

										Product newProduct = null;

										try {
											newProduct = catalog[productIndx - 1].clone();
										} catch (CloneNotSupportedException e) {
											e.printStackTrace();
										}

										newProduct.setQuantity(quantity);

										deals[dealNumber - 1].addProductToDeal(users[1], newProduct);

										catalog = Product.removeProductFromArray(catalog, newProduct);
										break;
									}
								}
							}
						}
					}
					break;
				// Profile
				case 2:
					int profileMenu;

					System.out.println("Профиль\n" + currentUser.getUserDescription());
					System.out.println("1. Изменить ФИО");
					System.out.println("2. Изменить номер мобильного телефона");
					System.out.println("3. Изменить адрес электронной почты");
					System.out.println("4. Изменить день рождения");
					System.out.print("0. Главное меню");

					do {
						System.out.print("\n>");
						profileMenu = scanner.nextInt();
						scanner.nextLine();
					} while (profileMenu < 0 || profileMenu > 4);

					if (profileMenu == 1) {
						System.out.print("Введите ФИО: ");
						String fio = scanner.nextLine();
						currentUser.setFullName(fio);
					} else if (profileMenu == 2) {
						String phone;

						System.out.print("Введите номер мобильного телефона: ");
						do {
							phone = scanner.nextLine();
						} while (!(new BelarusPhoneValidator().validate(phone)
								|| new AmericanPhoneValidator().validate(phone)));

						currentUser.setPhone(phone);
					} else if (profileMenu == 3) {
						String email;

						System.out.print("Введите адрес электронной почты: ");
						do {
							email = scanner.nextLine();
						} while (!(new EmailValidator().validate(email)));

						currentUser.setEmail(email);
					} else if (profileMenu == 4) {
						String birthday;

						System.out.print("Введите дату Вашего дня рождения (формат: dd/MM/yyyy): ");
						do {
							birthday = scanner.nextLine();
						} while (!(new DateValidator().validate(birthday)));

						currentUser.setBirthday(LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					}
					break;
				// Catalog
				case 3:
					int catalogMenu;

					while (true) {
						System.out.println("1. Показать каталог");
						if (currentUser.getRole().equals(Role.SELLER))
							System.out.println("2. Добавить товар");
						System.out.println("0. Главное меню");
						do {
							System.out.print(">");
							catalogMenu = scanner.nextInt();
							scanner.nextLine();
						} while (currentUser.getRole().equals(Role.SELLER) ? (catalogMenu < 0 || catalogMenu > 2)
								: (catalogMenu < 0 || catalogMenu > 1));

						if (catalogMenu == 1) {
							System.out.println("Каталог:");
							for (Product p : catalog) {
								System.out.println(p.getDescription());
							}
						} else if (catalogMenu == 2) {
							int productID;

							System.out.println("1. Ноутбук");
							System.out.println("2. Мобильный телефон");
							System.out.println("3. Телевизор");

							do {
								System.out.print(">");
								productID = scanner.nextInt();
								scanner.nextLine();
							} while (productID < 1 || productID > 3);

							String name, model;
							double price;
							int quantity;

							System.out.print("Введите название: ");
							name = scanner.nextLine();

							System.out.print("Введите название модели: ");
							model = scanner.nextLine();

							System.out.print("Введите количество товара: ");
							quantity = scanner.nextInt();

							System.out.print("Введите цену: ");
							price = scanner.nextDouble();
							scanner.nextLine();

							if (productID == 1) {
								int processor, ram;

								System.out.print("Введите частоту процессора(МГц): ");
								processor = scanner.nextInt();

								System.out.print("Введите количество ОЗУ: ");
								ram = scanner.nextInt();

								catalog = Product.addProductToArray(catalog,
										new Laptop(name, price, quantity, model, processor, ram));
							} else if (productID == 2) {
								Color color;
								float camera;

								System.out.println("Введите цвет. Возможные цвета: ");
								for (Color c : Color.values()) {
									System.out.println(c.getName());
								}

								do {
									System.out.print(">");
									color = Color.getColorByName(scanner.nextLine());
								} while (color == null);

								System.out.print("Введите количество МП камеры: ");
								camera = scanner.nextFloat();

								catalog = Product.addProductToArray(catalog,
										new MobilePhone(name, price, quantity, model, color, camera));
							} else if (productID == 3) {
								Resolution resolution;
								float diagonal;

								System.out.println("Введите разрешение экрана. Возможные варианты: ");
								for (Resolution r : Resolution.values()) {
									System.out.println(r.getName());
								}

								do {
									System.out.print(">");
									resolution = Resolution.getResolutionByName(scanner.nextLine());
								} while (resolution == null);

								System.out.print("Введите диагональ экрана: ");
								diagonal = scanner.nextFloat();

								catalog = Product.addProductToArray(catalog,
										new TV(name, price, quantity, model, diagonal, resolution));
							}
						} else if (catalogMenu == 0) {
							break;
						}
					}
				}
			}
		}
		scanner.close();
	}
}