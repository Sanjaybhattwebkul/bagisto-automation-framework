package JavaPorograms;

public class B extends A{
	
	public static void main(String args[]) 
	{
		B obj  = new B();
		
		obj.sum();
	}
	
	public  void sum() {
		
		super.sum();
		System.out.print("I ma b class");
	}
}
