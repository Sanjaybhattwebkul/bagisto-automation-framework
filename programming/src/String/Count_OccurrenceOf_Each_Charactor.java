package String;

import java.util.HashMap;
import java.util.Scanner;

public class Count_OccurrenceOf_Each_Charactor {

	public static void main(String[] args) {
		Scanner str= new Scanner(System.in);
		System.out.println("Enter any String");
		String inputString = str.nextLine().replaceAll("\\s","");
		
		// Creating a HashMap containing char
        // as a key and occurrences as  a value
        HashMap<Character, Integer> charCountMap
            = new HashMap<Character, Integer>();
 
        // Converting given string to char array
 
        char[] strArray = inputString.toCharArray();
 
        // checking each char of strArray
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
 
                // If char is present in charCountMap,
                // incrementing it's count by 1
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else {
 
                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                charCountMap.put(c, 1);
            }

	}
        System.out.println(charCountMap);

	}

}
