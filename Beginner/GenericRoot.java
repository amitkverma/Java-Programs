/* program to find a generic root like 155=1+5+5=11=1+1=2 of any Number */

import java.util.Scanner;

public class GenericRoot
{
	public static void main(String[] agrs)
	{
		GenericRoot root=new GenericRoot();
		Scanner in=new Scanner(System.in);
		root.FindGenericRoot(in.nextInt());
	}
	private void FindGenericRoot(int Number)
	{
		int sum=0;
		while(Number>10)
		{
			while(Number!=0)
			{
				int r=Number%10;
				Number=Number/10;
				sum=sum+r;
			}
			if(sum>10)
			{
				Number=sum;
				sum=0;
			}
			else
			{
				break;
			}
		}
		System.out.println("Generic root of system is: "+sum);
	}
}