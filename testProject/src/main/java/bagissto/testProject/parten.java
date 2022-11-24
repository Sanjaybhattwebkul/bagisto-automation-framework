package bagissto.testProject;

public class parten {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter=1;
		for(int i=1;i<4;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);	
				System.out.print("\t");	
				
				counter++;		
			}	
			System.out.println("");
			
			System.out.println("counter="+counter+ "i="+ i);
		}
	

	}

}
