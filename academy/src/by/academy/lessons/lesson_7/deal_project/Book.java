package by.academy.lessons.lesson_7.deal_project;

import java.util.Arrays;
import java.util.Objects;

public class Book extends Product {
	protected String[] authors;
	protected int pageNumber;

	public Book() {
		super();
	}

	public Book(String name, double price, int quantity, String[] authors, int pageNumber) {
		super(name, price, quantity);
		this.authors = authors;
		this.pageNumber = pageNumber;
	}

	@Override
	protected double calcDiscount() {
		if (pageNumber > 500 || quantity > 1)
			return 0.2;
		return 0;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(authors);
		result = prime * result + Objects.hash(pageNumber);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Arrays.equals(authors, other.authors) && pageNumber == other.pageNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [authors=");
		builder.append(Arrays.toString(authors));
		builder.append(", pageNumber=");
		builder.append(pageNumber);
		builder.append("]");
		return builder.toString();
	}
}