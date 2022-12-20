package javaProgram;

import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String :");
		String inputString = sc.nextLine();
		String[] stringArray = inputString.split(" ");
	
		for(int i=stringArray.length; i>0; i--) {
			System.out.print(stringArray[i-1]+" ");
		}

	}

}
