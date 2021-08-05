package by.academy.deal.enums;

public enum Role {
	SELLER("Продавец"), CUSTOMER("Покупатель");

	private String roleName;

	private Role(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}
}