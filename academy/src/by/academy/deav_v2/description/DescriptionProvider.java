package by.academy.deav_v2.description;

import by.academy.deav_v2.entities.products.Laptop;
import by.academy.deav_v2.entities.products.MobilePhone;
import by.academy.deav_v2.entities.products.Product;
import by.academy.deav_v2.entities.products.TV;

public final class DescriptionProvider {

	public static String getDescription(Product product) {
		StringBuilder builder = new StringBuilder();

		provideInfo(product, builder);

		builder.append(product.getPrice());
		builder.append(" руб");
		builder.append(" x ");
		builder.append(product.getQuantity());

		return builder.toString();
	}

	public static String getBillDescription(Product product) {
		StringBuilder builder = new StringBuilder();

		provideInfo(product, builder);

		builder.append("| ");
		builder.append(product.getQuantity());
		builder.append(" x ");
		builder.append(product.getPrice());
		builder.append(" - ");
		builder.append(Math.round(product.calcDiscount() * 10000) / 100.0);
		builder.append("% = ");
		builder.append(product.calcPrice());
		builder.append(" руб");

		return builder.toString();
	}

	private static void provideInfo(Product product, StringBuilder info) {
		if (product instanceof Laptop) {
			provideLaptopInfo((Laptop) product, info);
		} else if (product instanceof MobilePhone) {
			provideMobilePhoneInfo((MobilePhone) product, info);
		} else if (product instanceof TV) {
			provideTVInfo((TV) product, info);
		}
	}

	private static void provideLaptopInfo(Laptop laptop, StringBuilder info) {
		info.append("Ноутбук ");
		info.append(laptop.getName());
		info.append(" ");
		info.append(laptop.getModel());
		info.append(" (");
		info.append("частота процессора ");
		info.append(laptop.getProcessor());
		info.append(" МГц, ");
		info.append("ОЗУ ");
		info.append(laptop.getRam());
		info.append(" ГБ");
		info.append(") ");
	}

	private static void provideMobilePhoneInfo(MobilePhone phone, StringBuilder info) {
		info.append("Мобильный телефон ");
		info.append(phone.getName());
		info.append(" ");
		info.append(phone.getModel());
		info.append(" (");
		info.append(phone.getColor().getName());
		info.append(") ");
		info.append(phone.getCamera());
		info.append(" МП ");
	}

	private static void provideTVInfo(TV tv, StringBuilder info) {
		info.append("Телевизор ");
		info.append(tv.getName());
		info.append(" ");
		info.append(tv.getModel());
		info.append(" (");
		info.append("диагональ ");
		info.append(tv.getDiagonal());
		info.append(" дюйма(-ов), ");
		info.append("разрешение ");
		info.append(tv.getResolution().getName());
		info.append(") ");
	}
}