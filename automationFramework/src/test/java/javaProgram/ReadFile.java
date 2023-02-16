package javaProgram;

import java.io.*;
public class ReadFile {

	public static void main(String[] args) throws IOException 
	{
		  File file = new File("//home//users//sanjay.bhatt//www//html//Bagisto-Automation//file.text"); 
		  BufferedReader br  = new BufferedReader(new FileReader(file));
		  String[] str  = br.readLine().split(" ");
		  for (int i=str.length-1; i >0; i--) {
			  System.out.print(str[i]+" ");
		  }
		  

	}

}
