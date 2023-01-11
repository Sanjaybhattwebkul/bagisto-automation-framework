package javaProgram;

import java.util.Scanner;

public class PalindromeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ant number");
		String number = sc.nextLine();
		String rev="";
		for (int i=number.length()-1; i>=0; i--) {
			rev = rev+number.charAt(i);
		}
		if(rev.equals(number)) {
			System.out.println("Number is PalindromNumber");
		} else {
			System.out.println("Number is not PalindromNumber");
		}

	}

}
