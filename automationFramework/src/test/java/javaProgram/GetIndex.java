package javaProgram;

public class GetIndex {

	public static void main(String[] args) {
		int[] array = {1,2,7,9,10};
		for(int i= 0; i<array.length;i++) {
			int one= array[i];
			int two = array[i+1];
			if(one+two==9) {
				System.out.println(i + " and "+ (i+1));
				break;
			}
		}
		checunique(0);
	}
	
	/*
	 * Check Palindrom Number
	 */
	public static void checunique(int number) {
		  int r,sum=0,temp;    
		  int n=454;//It is the number variable to be checked for palindrome  
		  
		  temp=n;    
		  while(n>0){    
		   r=n%10;  //getting remainder  
		  
		   sum=(sum*10)+r;  
		   
		   n=n/10;    
		   System.out.print("\n n = "+n);
		  }    
		  if(temp==sum)    
		   System.out.println("\n palindrome number ");    
		  else    
		   System.out.println("\n not palindrome");     
	}

}
