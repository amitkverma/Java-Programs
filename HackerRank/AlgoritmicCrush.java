/* Algorithmic Crush */

import java.util.Scanner;

public class AlgoritmicCrush
{	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		long[] arr=new long[N];
		int M=in.nextInt();
		while(M>0){
			int a=in.nextInt();
			int b=in.nextInt();
			int k=in.nextInt();
			updateList(arr,a,b,k);
			M--;
		}
		System.out.print(maxValue(arr));
	}
	public static void updateList(long[] a,int i,int j,int k){
		i=i-1;
		j=j-1;
		for(int m=i;m<=j;m++){
			a[m]=a[m]+(long)k;
		}
	}
	public static long maxValue(long[] a){
		long temp=a[0];
		for(int i=1;i<a.length;i++){
			if(a[i]>temp){
				temp=a[i];
			}
		}
		return temp;
	} 
}