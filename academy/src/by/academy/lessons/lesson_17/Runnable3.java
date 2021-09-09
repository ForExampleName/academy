package by.academy.lessons.lesson_17;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runnable3 implements Runnable {
	private Integer[] nums;

	public Runnable3() {
		super();
		nums = new Integer[10];
		Stream.generate(() -> new Random().nextInt(10)).limit(10).collect(Collectors.toList()).toArray(nums);
	}

	public Runnable3(Integer[] nums) {
		super();
		this.nums = nums;
	}

	@Override
	public void run() {
		Integer sum = 0;

		for (Integer val : nums) {
			sum += val;
		}

		System.out.println("Average value is " + (double) sum / nums.length);
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
		Runnable3 other = (Runnable3) obj;
		return Arrays.equals(nums, other.nums);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Runnable3 [nums=");
		builder.append(Arrays.toString(nums));
		builder.append("]");
		return builder.toString();
	}
}