
public class Problem3
{
	public static void main(String[] args)
	{
		long value=600851475143L;
		System.out.println(greatestFactor(value));
	}
	public static long greatestFactor(long value)
	{
		long div=2;
		while(value>1)
		{
			if(value%div==0)
			{
				value=value/div;
			}
			else
			{
				div=nextPrime(div);				
			}
		}
		return div;
	}
	public static long nextPrime(long num)
	{
		for(long i=num+1;i<Long.MAX_VALUE;i++)
		{
			boolean isPrime=true;
			for(long j=i-1;j>=2;j--)
			{
				if(i%j==0)
				{
					isPrime=false;
					break;
				}
			}
			if(isPrime)
			{
				return i;
			}
		}
		return -1;
	}
	
}