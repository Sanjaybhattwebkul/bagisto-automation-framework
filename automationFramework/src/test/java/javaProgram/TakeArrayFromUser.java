package javaProgram;
import java.util.Scanner;

public class TakeArrayFromUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Size Of Array");
		int size = 0;
		if (sc.hasNext()) {
			size = sc.nextInt();
		}
		
		System.out.println("Enter Element Of Array");
		
		int[] arr = new int[size];
		for (int i=0; i < size; i++) {
			if (sc.hasNext()) {
				arr[i] = sc.nextInt();
			}
		}
		
		getHeighestMarks(arr);

	}
	
	public static void getHeighestMarks(int[] arr) {
		for (int i=0; i < arr.length; i++) {
			int temp;
			for (int j=0; j <arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("Heighest number is "+arr[0]+" And Lowest number is "+ arr[arr.length-1]);
	}

}
