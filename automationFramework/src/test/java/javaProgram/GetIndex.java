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

	}

}
