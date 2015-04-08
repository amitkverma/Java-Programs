/* Display even and odd Series and also check if nunmber is even or odd */

import java.util.Scanner;

public class EvenAndOdd
{
	public static void main(String[] args)
	{
		EvenAndOdd num=new EvenAndOdd();
		Scanner in1=new Scanner(System.in);
		Scanner in2=new Scanner(System.in);
		num.OddSeries(in1.nextInt(),in2.nextInt());
	}
	private void IsEven(int Number)
	{
		if(Number%2==0)
		{
			System.out.println(true);
			return;
		}
		System.out.println(false);
	}
	private void IsOdd(int Number)
	{
		if(Number%2==0)
		{
			
			System.out.println(false);
			return;
		}
		System.out.println(true);
	}
	private void EvenSeries(int startNumber,int endNumber)
	{
		if(startNumber>0)
		{
			for(int i=startNumber;i<=endNumber;i++)
			{
				if(i%2==0)
				{
					System.out.print(i+",");
				}
			}
		}
	}
	private void OddSeries(int startNumber,int endNumber)
	{
		if(startNumber>0)
		{
			for(int i=startNumber;i<=endNumber;i++)
			{
				if(i%2!=0)
				{
					System.out.print(i+",");
				}
			}
		}
	}
}