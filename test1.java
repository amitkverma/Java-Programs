import java.util.Scanner;

public class test1{
    
    public static void main(String[] args){
		System.out.println(round(5,3));
    }
	private static int arraySum(int[] arr)
	{
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			sum=sum+arr[i];
		}
		return sum;
	}
    private static int round(int sum,int N){
       int r1=sum/N;
       double r2=(double)sum/N;
       double r3=(double)r1+0.40;
	   System.out.println(r1+" "+r2+" "+r3);
        if(r2>=r3){
            return r1+1;
        }
        return r1;
    }	
}