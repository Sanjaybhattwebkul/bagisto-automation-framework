package javaProgram;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Parten {

	public static void main(String[] args) {
		int[] array = {1,2,4,5,6,8,10,12,14};
		
		int previoUSNumber = array[0];
		ArrayList<Integer>missingNumbers=new ArrayList<Integer>();
		for (int i=1; i < array.length; i++) {
			if (array[i] == previoUSNumber+1) {
				previoUSNumber = array[i];
			
			} else {
				missingNumbers.add(previoUSNumber+1);
				previoUSNumber = previoUSNumber+2;
				
			}
		}
		
		System.out.println(missingNumbers);

	}

}
