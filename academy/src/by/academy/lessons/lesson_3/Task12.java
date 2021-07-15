package by.academy.lessons.lesson_3;

import java.util.Arrays;
import java.util.Random;

public class Task12 {

	public static void sorting(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				int temp = 0;
				if(arr[j]<arr[i]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return ;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		int[][] array = new int[6][7];
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				array[i][j] = random.nextInt(10);
			}
		}
		
		System.out.println(Arrays.deepToString(array));
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				array[i][j] = random.nextInt(10);
			}
		}
		
		for(int[] subarr: array) {
			sorting(subarr);
		}
		
		System.out.println(Arrays.deepToString(array));
	}

}
