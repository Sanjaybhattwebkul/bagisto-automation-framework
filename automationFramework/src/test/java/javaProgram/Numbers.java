package javaProgram;

public class Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkNumbers(2, 5);

	}

	public static void checkNumbers(int number_one, int number_two) {
		if ((number_one % 2 == 0 && number_two % 2 != 0) || (number_two % 2 == 0 && number_one % 2 != 0) ) {
			System.out.print(number_one * number_two);
		} else {
			System.out.println("Condition mismatch");
		}
	}

}
