package by.academy.lessons.lesson_17;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Runnable1 implements Runnable {
	private Integer[] nums;

	public Runnable1() {
		super();
		nums = new Integer[10];
		Stream.generate(() -> new Random().nextInt(10)).limit(10).collect(Collectors.toList()).toArray(nums);
	}

	public Runnable1(Integer[] nums) {
		super();
		this.nums = nums;
	}

	@Override
	public void run() {
		System.out.println("Min value is " + Arrays.stream(nums).min((prev, cur) -> (prev - cur)).get());
	}

	public Integer[] getNums() {
		return nums;
	}

	public void setNums(Integer[] nums) {
		this.nums = nums;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(nums);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Runnable1 other = (Runnable1) obj;
		return Arrays.equals(nums, other.nums);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Runnable1 [nums=");
		builder.append(Arrays.toString(nums));
		builder.append("]");
		return builder.toString();
	}
}