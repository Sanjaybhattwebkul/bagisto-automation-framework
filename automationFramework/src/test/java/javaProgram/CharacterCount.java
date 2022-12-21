package javaProgram;

import java.util.*;
import java.util.Scanner;

public class CharacterCount {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String:");
		String inputString = sc.nextLine().replaceAll("\\s", "");
		char[] inputArray = inputString.toCharArray();
		HashMap<Character,Integer> hashMap = new HashMap<Character,Integer>();
		for(char word:inputArray) {
			if(hashMap.containsKey(word)) {
				hashMap.put(word, hashMap.get(word)+1);
			}else {
				hashMap.put(word, 1);
			}
		}
		System.out.println(hashMap);
	}
}
