package javaProgram;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
public class ReadFile {

	public static void main(String[] args) throws IOException 
	{
		  File file = new File("//home//users//sanjay.bhatt//www//html//Bagisto-Automation//file.text"); 
		  BufferedReader br  = new BufferedReader(new FileReader(file));
		  String[] str  = br.readLine().split(" ");
		  for (int i=str.length-1; i >0; i--) {
			 // System.out.print(str[i]+" ");
		  }
		  
		  getMostRepetedWord();
	}
	
	public static void getMostRepetedWord() throws IOException
	{
		File file = new File("//home//users//sanjay.bhatt//www//html//Bagisto-Automation//file.text");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str[] = br.readLine().split(" ");
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for (String word:str) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word)+1);
			} else {
				map.put(word, 1);
			}
		}
		
		
		
		Collection<Integer> values = map.values();
		Object[] obj = values.toArray();
		
		
		for (int i=0; i < obj.length; i++) {			
			int temp;
			
			for (int j=0; j < obj.length-1; j++) {
				
				if ((int)obj[i] > (int)obj[j]) {
					temp = (int)obj[i];
					obj[i] = (int)obj[j];
					obj[j] = temp;
				}
			}
		}
			
		System.out.print(Arrays.toString(obj));
		
		int count=1;
		for (Entry<String, Integer> entry:map.entrySet()) {
			System.out.println(entry.getValue() + " == " +obj[0]);
			if (entry.getValue() == obj[0] && count <= 1) {
				count ++;
				System.out.println(entry.getKey());
				
			} else if (count > 1) {
				
				System.out.print(-1);
				break;
			}
		}
	}

}
