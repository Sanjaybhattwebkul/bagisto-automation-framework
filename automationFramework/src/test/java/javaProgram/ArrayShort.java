package javaProgram;

import java.util.Arrays;

public class ArrayShort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,2,1,4,5};
		sortTO(array,"ASC");
		//sortTO(array,"DESC");
	}
	
	public static void sortTO(int[] array,String Type) {
		int i,j;
		int temp;
		if(Type=="ASC") {
			for (i=0; i<array.length;i++) {
				for(j=0;j<array.length-1;j++) {
					if(array[i] > array[j]) {
						temp =array[i];
						array[i] =array[j];
						array[j]=temp;
					}
				}				
			}
			//System.out.print(Arrays.toString(array));
		} else if(Type=="DESC"){
			for (i=0; i<array.length;i++) {
				for(j=0;j<array.length-1;j++) {
					if(array[i] < array[j]) {
						temp =array[i];
						array[i] =array[j];
						array[j]=temp;
					}
				}				
			}
		}
		System.out.print(Arrays.toString(array));
	}

}
