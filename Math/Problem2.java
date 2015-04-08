public class Problem2
{
	public static void main(String[] args)
	{
		long data=4000000;
		long i=2;
		long sum=0;
		while(nthTerm(i)<data)
		{
			sum=sum+nthTerm(i);
			i=i+3;
		}
		System.out.println(sum);
	}
	public static long nthTerm(long n)
	{
		if(n==1||n==2)
		{
			return n;
		}
		return nthTerm(n-1)+nthTerm(n-2);
	}
}