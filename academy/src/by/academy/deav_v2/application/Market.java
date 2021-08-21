package by.academy.deav_v2.application;

import java.time.LocalDate;

import by.academy.deav_v2.entities.deal.Deal;
import by.academy.deav_v2.entities.deal.DealList;
import by.academy.deav_v2.entities.products.Laptop;
import by.academy.deav_v2.entities.products.MobilePhone;
import by.academy.deav_v2.entities.products.Product;
import by.academy.deav_v2.entities.products.TV;
import by.academy.deav_v2.entities.storage.account.Accounts;
import by.academy.deav_v2.entities.storage.account.User;
import by.academy.deav_v2.entities.storage.warehouse.Warehouse;
import by.academy.deav_v2.enums.Color;
import by.academy.deav_v2.enums.Resolution;
import by.academy.deav_v2.enums.Role;

public class Market {

	public static void main(String[] args) {

		Warehouse warehouse = new Warehouse();
		DealList deals = new DealList();
		Accounts accounts = new Accounts();
		UserInterface ui = new UserInterface();

		User currentUser = null;

		while (true) {

			if (!ui.programContinue()) {
				break;
			}

			currentUser = ui.login(accounts);
			if (currentUser == null) {
				continue;
			}

			while (true) {

				int mainMenu = ui.mainMenu();

				if (mainMenu == UserInterface.MENU_EXIT) {
					break;
				}

				switch (mainMenu) {
				// Deals
				case UserInterface.MAIN_MENU_DEALS:
					int dealsMenu = UserInterface.MENU_DEFAULT_VALUE;

					if (currentUser.getRole().equals(Role.SELLER)) {
						while (dealsMenu != UserInterface.MENU_EXIT) {
							dealsMenu = ui.dealsMenu(currentUser.getRole());

							ui.showDeals(deals);

							if (dealsMenu == UserInterface.DEALS_MENU_SELLER_COMPLETE) {
								ui.showDeals(deals);

								if (deals.isEmpty()) {
									continue;
								}

								int dealNumber = ui.dealNumberInput(deals.getDealsCount());
								ui.printBill(deals.completeDeal(dealNumber, accounts.getSeller()));

							}
						}

					} else if (currentUser.getRole().equals(Role.CUSTOMER)) {
						while (dealsMenu != UserInterface.MENU_EXIT) {
							dealsMenu = ui.dealsMenu(currentUser.getRole());

							if (dealsMenu == UserInterface.DEALS_MENU_CUSTOMER_READ
									|| dealsMenu == UserInterface.DEALS_MENU_CUSTOMER_DELETE) {
								ui.showDeals(deals);

								if (dealsMenu == UserInterface.DEALS_MENU_CUSTOMER_READ || deals.isEmpty()) {
									continue;
								}

								int dealNumber = ui.dealNumberInput(deals.getDealsCount());
								warehouse.addProducts(deals.removeDeal(dealNumber));

								ui.removeDeal(dealNumber);

							} else if (dealsMenu == UserInterface.DEALS_MENU_CUSTOMER_CREATE) {
								int newDealMenu = UserInterface.MENU_DEFAULT_VALUE;
								Deal deal = new Deal();

								while (newDealMenu != UserInterface.MENU_EXIT) {
									newDealMenu = ui.newDealMenu(deal);

									if (newDealMenu == UserInterface.NEW_DEAL_MENU_ADD_PRODUCT) {
										if (warehouse.isEmpty()) {
											ui.emptyCatalog();
											if (deal.isEmpty())
												ui.cancelDeal();
											else
												ui.dealSaved();
											break;
										}

										ui.showCatalog(warehouse.getCatalog());
										ui.showRestOfMoney(currentUser);

										Product newProductForDeal = ui.productInput(warehouse.getCatalog());

										if (deal.addProduct(newProductForDeal)) {
											warehouse.pickProduct(newProductForDeal);
										}
									}
								}

								if (!deal.isEmpty()) {
									deal.setCustomer(currentUser);
									deal.setDealDate(LocalDate.now());
									deals.addDeal(deal);

									ui.makeDeal();
								}

							} else if (dealsMenu == UserInterface.DEALS_MENU_CUSTOMER_UPDATE) {
								ui.showDeals(deals);

								int dealNumber = ui.dealNumberInput(deals.getDealsCount());
								Deal dealToChange = deals.getDeal(dealNumber);

								int action = ui.changeDealMenu();

								if (action == UserInterface.UPDATE_DEAL_MENU_ADD_PRODUCT) {
									ui.showDealProducts(deals.getDeal(dealNumber));

									Product toRemove = ui.productInput(dealToChange.getProducts());

									dealToChange.removeProduct(toRemove);
									warehouse.addProduct(toRemove);

								} else if (action == UserInterface.UPDATE_DEAL_MENU_REMOVE_PRODUCT) {
									ui.showCatalog(warehouse.getCatalog());

									Product newProductForDeal = ui.productInput(warehouse.getCatalog());

									if (dealToChange.addProduct(newProductForDeal)) {
										warehouse.pickProduct(newProductForDeal);
									}
								}
							}
						}
					}
					break;
				// Profile
				case 2:
					int profileMenu = ui.profileMenu(currentUser);

					if (profileMenu == UserInterface.PROFILE_MENU_CHANGE_FIO) {
						currentUser.setFullName(ui.fioInput());
					} else if (profileMenu == UserInterface.PROFILE_MENU_CHANGE_PHONE) {
						currentUser.setPhone(ui.phoneInput());
					} else if (profileMenu == UserInterface.PROFILE_MENU_CHANGE_EMAIL) {
						currentUser.setEmail(ui.emailInput());
					} else if (profileMenu == UserInterface.PROFILE_MENU_CHANGE_BIRTHDAY) {
						currentUser.setBirthday(ui.birthdayInput());
					}

					break;
				// Catalog
				case 3:
					int catalogMenu = UserInterface.MENU_DEFAULT_VALUE;

					while (catalogMenu != UserInterface.MENU_EXIT) {

						if (catalogMenu == UserInterface.CATALOG_MENU_ADD_PRODUCT) {
							ui.showCatalog(warehouse.getCatalog());
						} else if (catalogMenu == UserInterface.CATALOG_MENU_SHOW) {
							int productID = ui.productIdInput();

							String name = ui.productNameInput();
							String model = ui.productModelInput();
							double price = ui.productPriceInput();
							int quantity = ui.productQuantityInput();

							if (productID == UserInterface.LAPTOP_ID) {
								int processor = ui.processorInput();
								int ram = ui.ramInput();

								warehouse.addProduct(new Laptop(name, price, quantity, model, processor, ram));
							} else if (productID == UserInterface.PHONE_ID) {
								Color color = ui.colorInput();
								float camera = ui.cameraInput();

								warehouse.addProduct(new MobilePhone(name, price, quantity, model, color, camera));
							} else if (productID == UserInterface.TV_ID) {
								Resolution resolution = ui.resolutionInput();
								float diagonal = ui.diagonalInput();

								warehouse.addProduct(new TV(name, price, quantity, model, diagonal, resolution));
							}
						}
					}
				}
			}
		}
	}
}