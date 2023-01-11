package javaProgram;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any number");
		int input = sc.nextInt();

		String str = Integer.toString(input);
		double total=0;;
		for (int i=0;i<str.length(); i++) {
		    int word = Integer.parseInt(String.valueOf(str.charAt(i)));
		     total =  (total+(Math.pow(word,str.length())));
		}

		if(total == input) {
		    System.out.println("This is armstrong number");
		} else{
		    System.out.println("This is not  a armstrong number");
		}
		// calling another function
		test(input);
	}
	
	public static void test(int number) {
		String str = Integer.toString(number);
		double total =0;
		for(int i=0; i < str.length(); i++) {
			double n= Integer.parseInt(str.valueOf(str.charAt(i)));
			total = total+(Math.pow(n, str.length()));
		}
		
		if(total == number) {
			System.out.println("NUmber is armstrong-number");
		}else {
			System.out.println("NUmber is not armstrong-number");
		}
	}

}
