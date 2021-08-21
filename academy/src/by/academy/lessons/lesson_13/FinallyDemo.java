package by.academy.lessons.lesson_13;

public class FinallyDemo {
	public static void procA() throws RuntimeException{
		try {
			System.out.println("Inside procA");
			throw new RuntimeException("demo");
		}finally {
			System.out.println("procA and finally");
		}
	}
	
	public static void procB() {
		try {
			System.out.println("Inside procB");
			return;
		}finally {
			System.out.println("procB and finally");
		}
	}
	
	public static void procC() {
		try {
			System.out.println("Inside procC");
			
		}finally {
			System.out.println("procC and finally");
		}
	}
	
	
	public static void main(String[] args) {
//		launch procA, procB and procC separately 
		
//		try {
//			procA();
//		}catch(Exception e) {
//			System.out.println("We have exception");
//		}
		
//		procB();
		
		procC();
		
		System.out.println("test");
	}
}