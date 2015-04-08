import java.util.Scanner;

public class GoogleC
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		for(int i=1; i<=N;i++)
		{
			double B=in.nextDouble()*750.0;
			int L=in.nextInt();
			float G=in.nextFloat();
			double contains=B;
			for(int j=1;j<L;j++)
			{
				contains=contains-250.0f;
				contains=contains/3;
			}
			if(contains<0.0f)
			{
				System.out.println("Case #"+i+": "+"0.0000000");				
			}else
			if(contains>250.0f)
			{
				System.out.println("Case #"+i+": "+"250.0000000");
			}
			else
			{
				System.out.println("Case #"+i+": "+String.format("%.7f", contains));						
			}
		}
	}
}
