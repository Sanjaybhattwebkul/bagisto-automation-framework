package javaProgram;

import java.util.*;
import java.util.Map.Entry;

public class CharacterCount {

	public static void main(String[] args) {		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Any Number or String");
		String inputs = sc.nextLine().replaceAll("\\s", "");
		countCharWithHashMap(inputs);
		countCharWithoutHashMap(inputs);
	}	

	
	/*
	 * Count each character's occurrence using HashMap
	 */
	public static void countCharWithHashMap(String inputs) {
		char[] charArray = inputs.toCharArray();
		HashMap<Character,Integer>map= new HashMap<Character,Integer>();
		for(char words:charArray) {
			if(map.containsKey(words)) {
				map.put(words, map.get(words)+1);
			} else { 
				map.put(words, 1);
			}
		}
		
		System.out.println(map);
		
		Collection<Integer> values = map.values();
		Object[] obj = values.toArray();
		for(int i=0; i<obj.length;i++) {
			int temp;
			for(int j=0; j<obj.length;j++) {
				if((int)obj[i]> (int)obj[j]) {
					temp = (int)obj[i];
					obj[i] = obj[j];
					obj[j] = temp;
				}
			}
		}
		
		for(Entry<Character,Integer> entry:map.entrySet()) {
			if(entry.getValue()== obj[1]) {
				System.out.println("\nSecond Heighest Occoring word is: "+ entry.getKey() + " -> "+ entry.getValue());
			}
		}
	}
	
	/*
	 * Count occurrence of each word is string witout HashMap
	 */
	public static void countCharWithoutHashMap(String str) {
        ArrayList<String> newArray = new ArrayList<String>();
         for(int s = 0; s<str.length();s++) {
        	 char ch = str.charAt(s);
             int count = 0;
             int i;
        	 for (i = 0; i < str.length(); i++) {
                 if (str.charAt(i) == ch) {
                     count++;
                     newArray.add(str.charAt(i)+"-"+count);
                 }else {
                	 newArray.add(str.charAt(i)+"-1");
                 }
             }
        	
             System.out.println(ch+" -> " +count);
            
         }
         System.out.println(newArray);
        
	}
	
	
}
