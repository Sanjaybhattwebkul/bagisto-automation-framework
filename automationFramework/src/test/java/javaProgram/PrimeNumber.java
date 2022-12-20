package javaProgram;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner  sc =  new Scanner(System.in);
		System.out.println("Enter Number:");
		int inputNumber = sc.nextInt();
		
		if(checkPrime(inputNumber)) {
			System.out.println(inputNumber+ "  is not a prime number");
		}else {
			System.out.println(inputNumber+ "  is  a prime number");
		}
	}
	
	public static boolean checkPrime(int inputNumber) {
		boolean isPrime  = false;
		for (int i=2; i<inputNumber/2;i++) {
			if(inputNumber%2==0) {
				isPrime = true;
				
			} else {
				
			}
		}
		return isPrime;
	}
}
