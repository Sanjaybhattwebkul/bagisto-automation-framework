package javaProgram;

import java.util.*;

public class ReversString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Any String");
		
		String str = sc.nextLine().replaceAll(" ", "");
		
		for (int i=str.length()-1; i>=0; i--) {
			
			System.out.print(str.charAt(i));
		}
		

	}

}
