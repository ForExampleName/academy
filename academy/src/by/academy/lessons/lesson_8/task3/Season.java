package by.academy.lessons.lesson_8.task3;

public enum Season {
	Winter(-10),

	Spring(5) {
		public String getDescription() {
			return new String("Cold-warm season");
		}
	},

	Summer(23) {
		public String getDescription() {
			return new String("Warm season");
		}
	},

	Autumn(5) {
		public String getDescription() {
			return new String("Warm-cold season");
		}
	};

	private int averageTemperature;

	private Season(int averageTemperature) {
		this.averageTemperature = averageTemperature;
	}

	public int getAverageTemperature() {
		return averageTemperature;
	}

	public String getDescription() {
		return new String("Cold season");
	}
};