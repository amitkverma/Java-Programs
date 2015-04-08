/* Find The Power of the Number */

public class PowerOfNumber
{
	public static void main(String[] args)
	{
		PowerOfNumber num=new PowerOfNumber();
		num.FindPowerOfNumber(81,3);
	}
	private void FindPowerOfNumber(int Number,int pow)
	{
		if(Number<pow)
			return;
			
		int temp=Number;
		int i=0;
		while(Number%pow==0)
		{
			i++;
			Number=Number/pow;
		}
		System.out.println(temp+" is equals to "+pow+"^"+i);
	}
}