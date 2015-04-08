/* Design a recursive function for series ((1 + 2 … + x-1 + x) +y) */

public class Recursion
{
	public static void main(String[] args)
	{
		Recursion rcs=new Recursion();
		int result=rcs.pow(2,4);
		
		System.out.println(result);
	}
	private int Rec(int x,int y)
	{
		if(x==0)
			return y;
		else
			return Rec(x-1,x+y);
	}
	private int pow(int base,int power)
	{
		if(power<=1)
		{
			return base;
		}
		return base*pow(base,power-1);
	}
}