import java.util.Scanner;
import java.io.*;

class javaInput{
	BufferedReader in;
    public javaInput(){
        in = new BufferedReader(new InputStreamReader(System.in));
    }
    public int Uint(){
        int x=0;
        try{
            int c = in.read();
            //System.out.print(c);
            while(c<48 || c>57) c = in.read();
            while(c>47 && c<58){
                x = (x<<1) + (x<<3) + c-48;
                c = in.read();
            }
        } catch(IOException e){
            System.out.println(e.toString());
        }

        return x;
    }
	public int Int(){
        int x=0;
		int sign = 1;
        try{
            int c = in.read();
            //System.out.print(c);
            while((c<48 || c>57)&&c!='-') c = in.read();
			if(c=='-'){
				sign *= -1;
				c = in.read();
			}
            while(c>47 && c<58){
                x = (x<<1) + (x<<3) + c-48;
                c = in.read();
            }
        } catch(IOException e){
            System.out.println(e.toString());
        }
		x *= sign;
        return x;
    }
}
public class XORlove
{
	static long[] sums = new long[100001]; 
	static void printArray(long[] array, int n){
		for(int i=0; i<n; i++){
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i=0; i<n; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		// Scanner in=new Scanner(System.in);
		// int N=in.nextInt();
		javaInput input = new javaInput();
		 int N=input.Uint();
		long[] list=new long[N];
		long result=0;
		for(int i=0;i<N;i++) {
			list[i]= input.Uint();
			if(i==0)
				sums[i] = list[i];
			else
				sums[i] = sums[i-1] + list[i];
		}
		printArray(sums, N);
		int M=input.Uint();
		for(int i=0;i<M;i++)
		{
			result=KPRsum(input.Uint(),input.Uint(),input.Uint(),list);
			System.out.println("result: " + result);
		}
	}
	public static long KPRsum(int K,int P,int R,long[] A)
	{
		System.out.println(K + " " + P + " " + R);
		long sum=0;
		for(int i=P-1;i<R-1;i++)
		{
			System.out.println("Sum: " + (sums[R-1]-sums[i]));
			sum += K^(A[i]^(sums[R-1]-sums[i]));
			System.out.println("sum: " + (sum));
			
			// for(int j=i+1;j<=R;j++)
			// {
				// sum=sum+((K^(A[i-1]^A[j-1]))%1000000007);
				// // System.out.print(K+"^("+A[i-1]+"^"+A[j-1]+")"+" + ");
			// }
		}
		return sum;
	}
}