package by.academy.deav_v2.enums;

public enum Color {
	RED("Красный"), GREEN("Зелёный"), DARK_BLUE("Синий"), BLUE("Голубой"), WHITE("Белый"), BLACK("Чёрный");

	private String name;

	private Color(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Color getColorByName(String name) {
		switch (name) {
		case "Красный":
			return Color.RED;
		case "Зелёный":
			return Color.GREEN;
		case "Синий":
			return Color.DARK_BLUE;
		case "Голубой":
			return Color.BLUE;
		case "Белый":
			return Color.WHITE;
		case "Чёрный":
			return Color.BLACK;
		default:
			return null;
		}
	}
}