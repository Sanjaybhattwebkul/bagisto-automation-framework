package javaProgram;

import java.util.Scanner;

public class CheckUniqueNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Any Number");
		int inputNumber = sc.nextInt();		
		if(checkNumber(inputNumber)) {
			
			System.out.println(inputNumber +" is unique Number");
		} else {
			System.out.println(inputNumber +" is not unique Number");
		}
	}
	
	public static boolean checkNumber(int inputNumber) {
		boolean flag =true;		
		String number = Integer.toString(inputNumber);
		for(int i=0; i<number.length();i++) {
			for(int j=i+1; j<number.length(); j++) {
				if(number.charAt(i)== number.charAt(j)) {
					flag =false;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		return flag;
	}

}
