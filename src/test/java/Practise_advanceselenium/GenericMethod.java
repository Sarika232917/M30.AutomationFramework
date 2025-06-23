package Practise_advanceselenium;

public class GenericMethod {

	public static void main(String[] args) {
		int sum=add(10,20);
		System.out.println(sum);
		System.out.println(add(sum,40));
		System.out.println(add(40,40));
		
		//sub
		int diff=sub(10,20);
		System.out.println(diff);
		System.out.println(sub(diff,70));
		System.out.println(sub(50,70));
		
		//multiply
		int multiply=mul(10,70);
		System.out.println(multiply);
	    System.out.println(mul(multiply,40));
		System.out.println(mul(10,19));
		
		//divide
		int divide=div(10,70);
		System.out.println(divide);
	    System.out.println(div(divide,40));
		System.out.println(div(10,19));
		

	}
	
	public static int add(int a,int b)
	{
		int c=a+b;
		return c;
		
		
	}
	public static int sub(int x,int y)
	{
		//sub
	    int b=x-y;
	    return b;
				
	}
	public static int mul(int m,int y)
	{
		//sub
	    int d=m*y;
	    return d;
				
	}
	public static int div(int k,int o)
	{
		//sub
	    int v=k/o;
	    return v;
				
	}

}
