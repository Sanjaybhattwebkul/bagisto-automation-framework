package bagissto.core;

import org.openqa.selenium.WebDriver;

import com.beust.ah.A;

public class B {
	
	public void sum()
	{
		System.out.println("I am sum Of A");
	}
	
	public static void main(String args[])
	{
		String str= "ABACDC";
		char charArray[] = str.toCharArray();
		
		for(int i=0; i < charArray.length; i++) {
			int count=1;
			for(int j =i+1; j < charArray.length; j++) {
				if(charArray[i] == charArray[j]) {
					count++;
					charArray[j] = 0;
				}
			}
			if(count >1 && charArray[i] != 0) {
				System.out.println(charArray[i]);
			}
		}
		
		
		
		int a=10,b=20;
		b = a+b;
		a = b-a;
		b = b-a;
		
		System.out.println("a= " +a+ "b= "+b);
	}
}
