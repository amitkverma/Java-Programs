/* Fibonacci Series */
import java.util.Scanner;

public class Fibonacci
{
	public static void main(String[] args)
	{
		Fibonacci test=new Fibonacci();
		test.GenerateSeries(5);
	}
	public void GenerateFibonacciSeries()
	{		
		Scanner in=new Scanner(System.in);
		System.out.println("Plaese enter the lower limit of series");
		int lowerLimit=in.nextInt();
		System.out.println("Plaese enter the upper limit of series");
		int upperLimit=in.nextInt();
		System.out.println("your values are "+lowerLimit+", "+upperLimit);
		if(lowerLimit>upperLimit)
		{
			System.out.println("Plaese Put the lower limit less then upper limit");
			return;
		}
		if(lowerLimit>=0&&upperLimit>=0)
		{
			
		}
		else
		{
			System.out.println("Please enter the positive value");
		}
	}
	public int GenerateSeries(int y)
	{
		if(y==0)
		{
			return 0;
		}
		System.out.println(y);
		return GenerateSeries(y-1)+y;
	}
}