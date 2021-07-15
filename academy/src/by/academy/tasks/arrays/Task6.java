package by.academy.tasks.arrays;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Task6 {
	
	public static void main(String[] args) {
		char[] array = "***.............................................".toCharArray();
		char[] temp = new char[1]; 
		for(int i=0;i<1_000_000;i++) {
			System.out.println(array);
			
			System.arraycopy(array, array.length-1, temp, 0, 1);
			System.arraycopy(array, 0, array, 1, array.length-1);
			System.arraycopy(temp, 0, array, 0, 1);

			try {
				TimeUnit.MILLISECONDS.sleep(17);
			} catch (InterruptedException e) {
				break;
			}

			try {
				Runtime.getRuntime().exec("cls");
			} catch (IOException e) {
				break;
			}
		}
	}
}
