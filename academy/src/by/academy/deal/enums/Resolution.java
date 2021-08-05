package by.academy.deal.enums;

public enum Resolution {
	FULL_HD("Full HD"), UHD("4K");

	private String name;

	private Resolution(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Resolution getResolutionByName(String name) {
		switch (name) {
		case "Full HD":
			return Resolution.FULL_HD;
		case "4K":
			return Resolution.UHD;
		default:
			return null;
		}
	}
}