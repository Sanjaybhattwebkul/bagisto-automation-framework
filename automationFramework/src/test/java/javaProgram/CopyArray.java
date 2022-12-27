package javaProgram;

import java.util.Arrays;

public class CopyArray {

	/*
	 * Copy One array to another array
	 */
	public static void main(String[] args) {
		int[] firstArray   = {1,2,3,4,5,6,7};
		int[] secondArray = new int[firstArray.length];
		
		for (int i=0; i<firstArray.length;i++) {
			secondArray[i] = firstArray[i];
		}
		System.out.print(Arrays.toString(firstArray));
		System.out.print(Arrays.toString(secondArray));

	}

}
