package javaProgram;

public class ArrayElementMetch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array_one = { 1, 5, 3, 2 };
		int[] array_two = { 1, 2, 3, 5 };
		System.out.print(metch(array_one, array_two));
	}

	public static boolean metch(int[] array_one, int[] array_two) {
		int  j, count = 0;
		boolean value = false;
		for (int i = 0; i < array_one.length; i++) {

			for (j = 0; j < array_two.length; j++) {
				if (array_one[i] == array_two[j]) {
					count++;
					break;
				}
			}
			if (count == array_two.length) {
				value = true;
			}
		}
		
		return value;
	}

}
