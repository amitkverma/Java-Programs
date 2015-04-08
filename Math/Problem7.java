public class Problem7
{
	public static void main(String[] args)
	{
		int maxValue=0;
		int maxNum=10001;
		int num=3;
		int i=1;
		while(i<maxNum)
		{
			if(isPrime(num))
			{
				
				maxValue=num;
				i++;
			}
			num=num+2;
		}
		System.out.println(maxValue);
	}
	public static boolean isPrime(int value)
	{
		boolean isPrime=true;
		for(int i=value-2;i>=2;i-=2)
		{
			if(value%i==0)
			{
				isPrime=false;
				break;
			}
		}
		return isPrime;
	}
}