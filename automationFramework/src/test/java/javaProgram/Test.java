package javaProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Collection;

public class Test {

	public static void main(String[] args) {
		palindrom(111);
		characterOccuring();
		printOccuring("sanjuji");
		secondHeighestword("sanju ji is sanju ji sanju");
	}
	
	public static void characterOccuring() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any string");
		String str = sc.nextLine().replaceAll(" ", "");
		char[] charArray = str.toCharArray();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(char word: charArray) {
			if(map.containsKey(word)) {
				map.put(word, map.get(word)+1);
			}else {
				map.put(word,1);
			}
		}
		System.out.println(map);
		
		
	}
	
	/*
	 * Without HashMap
	 */
	public static void printOccuring(String str) {
		for(int i=0; i < str.length(); i++) {
			char  ch = str.charAt(i);
			int count =0;
			for(int j=0; j <str.length(); j++) {
				if(str.charAt(j) == ch) {
					count++;
				}
			}
			System.out.print(ch+" "+count+ " , ");
			str = str.replaceAll(""+ch, "");
			if(str.length() > 0) {
				printOccuring(str);
			}
			break;
		}
	}
	
	public static void secondHeighestword(String str) {
		String[] strArray = str.split(" ");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String word:strArray) {
			if(map.containsKey(word)) {
				map.put(word, map.get(word)+1);
			}else {
				map.put(word, 1);
			}
		}
		// sort array
		Collection<Integer> vaalues = map.values();
		Object[] obj = vaalues.toArray();
		
		for(int i=0; i < obj.length; i++) {
			int temp;
			for(int j=0; j < obj.length-1; j++) {
				if((int)obj[i] > (int)obj[j]) {
					temp=(int)obj[i];
					obj[i] = obj[j];
					obj[j] = temp;
				}
			}
		}
		// get Entry set
		for(Entry<String,Integer> entry:map.entrySet()) {
			if(entry.getValue() == obj[1]) {
				System.out.println(entry.getKey());
			}
		}
		
	}
	
	public static  void palindrom(int number) {
		String num = Integer.toString(number);
		String rev = "";
		for(int i=num.length()-1; i >= 0; i--) {
			rev = rev+num.charAt(i);
		}
		if(num.equals(rev) ) {
			System.out.println("this is palandrom");
		}else {
			System.out.println("This is not palandrom");
		}
	}
	

}
