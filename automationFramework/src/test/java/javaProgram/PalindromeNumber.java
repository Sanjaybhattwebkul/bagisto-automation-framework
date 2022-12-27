package javaProgram;

import java.util.Scanner;

public class PalindromeNumber {

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
		    System.out.println("This is palandrom number");
		} else{
		    System.out.println("This is not  a palamdrom number");
		}


	}

}
