package javaProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MissingNumber {

	public static void main(String[] args) 
	{		
		missingNumber();		
	}	
	
	/*
	 * Find missing number from array
	 * 
	 * @Return missing number from given array
	 */
	public static void missingNumber() {
		int[] array = {1,2,3,5,6,8,10};
		
		int previousNumber = array[0];
		
		ArrayList<Integer> missingNumbers = new ArrayList<Integer>();
	
		for (int i = 1; i <= array.length-1; i ++) {
			if (array[i] == previousNumber+1)  {				
				
				previousNumber = array[i];
				
			} else {	
				missingNumbers.add(previousNumber+1);
				previousNumber = previousNumber+2;
			}
		}
		
		System.out.print(missingNumbers);
	}
}
