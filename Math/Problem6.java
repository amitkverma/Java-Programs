public class Problem6
{
	public static void main(String[] agrs)
	{
		int value=100;
		int result=sumOfSeries(value)*sumOfSeries(value)-sumOfSquareSeries(value);
		System.out.println(result);
	}
	public static int sumOfSeries(int n)
	{
		return (n*(n+1))/2;
	}
	public static int sumOfSquareSeries(int n)
	{
		return (n*(n+1)*(2*n+1))/6;
	}
}