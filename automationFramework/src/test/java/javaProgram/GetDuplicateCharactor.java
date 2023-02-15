package javaProgram;


public class GetDuplicateCharactor {

	public static void main(String[] args) {
		getDuplicateCharactor("jiji");
		
	}
	
	/*
	 * Print the duplicate characters
	 * 
	 * @Return duplicate character of string
	 */
	public static void getDuplicateCharactor(String str) {
		char string[] = str.toCharArray();          
		for (int i = 0; i <string.length; i++) {    
           int count = 1;    
            for (int j = i+1; j <string.length; j++) {    
                if (string[i] == string[j]) {    
                    count++;      
                    string[j] = '0';  //Set string[j] to 0 to avoid printing visited character      
                }    
            }    
           
            if(count > 1 && string[i] != '0')     //A character is considered as duplicate if count is greater than 1    
                System.out.print(string[i]);    
        }  
	}	
	
}
