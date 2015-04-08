public class Problem5
{
	public static void main(String[] args)
	{
		int[] a={2,3,5,7,11,13,17,19};
		int result=1;
		for(int i=0;i<a.length;i++)
		{
			result=result*maxPowOfPrime(a[i],20);
		}
		System.out.println(result);
	}
	public static int maxPowOfPrime(int value,int range)
	{
		int temp=value;
		while(temp<range)
		{
			temp=temp*value;
		}
		temp=temp/value;
		return temp;
	}
}