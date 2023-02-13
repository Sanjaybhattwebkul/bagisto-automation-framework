package javaProgram;

import java.util.Scanner;

public class Fectorial {

    // Driver method
    public static void main(String[] args) {
        System.out.println("Enter any Number");
        Scanner sc = new Scanner(System.in);
    	int num = sc.nextInt();
        System.out.println("Factorial of " + num
                           + " is " + factorial(num));
    }
    
    // method to find factorial of given number
    static int factorial(int n) {
        if (n == 0)
            return 1;
 
        return n * factorial(n - 1);
    }
 

}