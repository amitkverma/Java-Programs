public class Problem1
{
	public static void main(String[] args)
	{
		int value=100000000;
		int l1=greatestMultipleOfThree(value);
		int l2=greatestMultipleOfFive(value);
		int n1=((l1-3)/3)+1;
		int l3=greatestMultipleOfFifteen(value);
		int n3=((l3-15)/15)+1;
		int n2=((l2-5)/5)+1;
		int sum1=(n1*(l1+3))/2;
		int sum2=(n2*(l2+5))/2;
		int sum3=(n3*(l3+15))/2;		
		int total=sum1+sum2-sum3;
		System.out.println(total);
	}
	public static int greatestMultipleOfThree(int value)
	{
		for(int i=value-1;i>0;i--)
		{
			if(i%3==0&&i%5!=0)
			{
				return i;
			}
		}
		return -1;
	}
	public static int greatestMultipleOfFifteen(int value)
	{
		for(int i=value-1;i>0;i--)
		{
			if(i%15==0)
			{
				return i;
			}
		}
		return -1;
	}	
	public static int greatestMultipleOfFive(int value)
	{
		for(int i=value-1;i>0;i--)
		{
			if(i%5==0&&i%3!=0)
			{
				return i;
			}
		}
		return -1;
	}
	
}