package javaProgram;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collection;

public class SecondHiegtReapting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Any String or Number");
		String inputSting  = sc.nextLine();
		String[] strArray = inputSting.split(" ");
		HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
		
		for(String word:strArray) {
			if(hashMap.containsKey(word)) {
				hashMap.put(word, hashMap.get(word)+1);
			}else {
				hashMap.put(word, 1);
			}
		}
		
		// System.out.println(hashMap); // print count of each character
		
		// Sort the count of each character in descending order.
		Collection<Integer> values = hashMap.values();
		Object[] objectValues = values.toArray();		
		
		 Arrays.sort(objectValues);
		 
		for(Entry<String, Integer> entry: hashMap.entrySet()) {
			if(entry.getValue()==objectValues[1]) {
				System.out.println(entry.getKey()+ " -> "+entry.getValue());
			}
		}
	}

}
