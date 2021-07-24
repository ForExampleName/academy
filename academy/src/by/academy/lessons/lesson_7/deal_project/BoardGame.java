package by.academy.lessons.lesson_7.deal_project;

import java.util.Objects;

public class BoardGame extends Product {
	protected int recommendedAge;
	protected String instruction;

	public BoardGame() {
		super();
	}

	public BoardGame(String name, double price, int quantity, int recommendedAge, String instruction) {
		super(name, price, quantity);
		this.recommendedAge = recommendedAge;
		this.instruction = instruction;
	}

	@Override
	protected double calcDiscount() {
		if (recommendedAge < 6 || quantity > 1)
			return 0.1;
		return 0;
	}

	public int getRecommendedAge() {
		return recommendedAge;
	}

	public void setRecommendedAge(int recommendedAge) {
		this.recommendedAge = recommendedAge;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(instruction, recommendedAge);
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
		BoardGame other = (BoardGame) obj;
		return Objects.equals(instruction, other.instruction) && recommendedAge == other.recommendedAge;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardGame [recommendedAge=");
		builder.append(recommendedAge);
		builder.append(", instruction=");
		builder.append(instruction);
		builder.append("]");
		return builder.toString();
	}
}