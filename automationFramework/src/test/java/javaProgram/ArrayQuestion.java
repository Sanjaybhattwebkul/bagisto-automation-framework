package javaProgram;

import java.util.ArrayList;

public class ArrayQuestion {

	/*
	 * Print 0's in the after all numbers
	 */
	public static void main(String[] args) {
		int[] Array = { 1, 0, 2, 0, 5, 6, 0, 1, 0, 0, 0 };
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < Array.length; i++) {
			if (Array[i] == 0) {
				count++;
			} else {
				list.add(Array[i]);
			}
		}
		for (int j = 0; j < count; j++) {
			list.add(0);
		}

		System.out.println(list);

	}

}
