/* Count Number of Digits in given Number */

import java.util.Scanner;

public class NumberOfDigit
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		NumberOfDigit num=new NumberOfDigit();		
		num.CountDigits(in.nextInt());
	}
	private void CountDigits(int num)
	{
		int temp=num;
		int i=0;
		while(temp!=0)
		{
			i++;
			temp=temp/10;
		}
		System.out.println("Number of Digits in "+num+" is: "+i);
	}
}