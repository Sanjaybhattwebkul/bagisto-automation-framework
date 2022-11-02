package String;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Print_Second_Heighest_Occurrence_Word {

	public static void main(String[] args) {
		Scanner str= new Scanner(System.in);
		System.out.println("Enter any String");
		String inputString = str.nextLine();
		String[] words = inputString.split(" ");
		 
		// Creating a HashMap containing char
        // as a key and occurrences as  a value
        HashMap<String, Integer> charCountMap = new HashMap<String, Integer>();
 
        // Converting given string to char array
 
       // char[] strArray = inputString.toCharArray();
 
        // checking each char of strArray
        for (String word : words) {
            if (charCountMap.containsKey(word)) {
 
                // If char is present in charCountMap,
                // incrementing it's count by 1
                charCountMap.put(word, charCountMap.get(word) + 1);
            }
            else {
 
                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                charCountMap.put(word, 1);
            }

	}
        //System.out.println(charCountMap);
        
        Collection<Integer> L = charCountMap.values(); // get only values of charCountMap array
        Object[] obj = L.toArray();
       // sort descending order to array of count of each word
        int temp;
        for(int i = 0;i<obj.length;i++) {
        	for(int j=0;j<obj.length-1;j++) {
        		if((int)obj[i] > (int)obj[j]) {
        			temp=(int)obj[i];
        			obj[i]=obj[j];
        			obj[j]=temp;
        		}
        	}
        }
     //   System.out.println(Arrays.toString(obj));
        for(Entry<String, Integer> entry:charCountMap.entrySet()) {
        		if(entry.getValue()==obj[1]) {
        			System.out.println(entry.getKey()+" - "+ entry.getValue());
        		}
        }

	}

}
