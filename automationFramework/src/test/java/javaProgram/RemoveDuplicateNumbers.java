package javaProgram;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicateNumbers {

	public static void main(String[] args) {
		removeDuplicate();

	}
	
	/*
	 * Remove Duplicate elements from the array
	 * 
	 * @return unique arrayList
	 */
	public static void removeDuplicate() {
		ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 3, 4, 5, 6, 1, 3));
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.size(); i++) {
			if (list.contains(array.get(i))) {
				array.remove(array.get(i));
			} else {
				list.add(array.get(i));
			}
		}
		System.out.println(list);
	}

}
