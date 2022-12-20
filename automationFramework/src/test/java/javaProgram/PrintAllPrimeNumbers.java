package javaProgram;

import java.util.Scanner;

public class PrintAllPrimeNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number :");
		int number = sc.nextInt();
		
		for(int i=2;i<=number;i++) {
			boolean isPrice =true;
			for(int j=2; j<i;j++) {				
				if(i%j==0) {					
					isPrice = false;
					break;
				}
			}
			if(isPrice) {
				System.out.print(" "+i);
			}
		}

	}

}
