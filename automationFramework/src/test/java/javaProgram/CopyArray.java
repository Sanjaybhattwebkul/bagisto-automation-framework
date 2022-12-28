package javaProgram;

import java.util.ArrayList;
import java.util.Arrays;

public class CopyArray {

	/*
	 * Copy One array to another array
	 */
	public static void main(String[] args) {
		int[] firstArray   = {1,2,3,4,5,6,7};
		int[] secondArray = new int[firstArray.length];		
		
		ArrayList<Integer> list = new ArrayList<Integer>();		
		
		for (int i=0; i<firstArray.length;i++) {
			secondArray[i] = firstArray[i];
			list.add(firstArray[i]);
		}
		System.out.print(Arrays.toString(firstArray));
		System.out.print(Arrays.toString(secondArray));
		System.out.print(list);

	}

}
