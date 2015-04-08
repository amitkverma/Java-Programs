/* Insertion Sort Advanced Analysis */

import java.util.Scanner;

public class InsertionSortAdvancedAnalysis
{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		while(T>0){
			int L=in.nextInt();
			int[] a=new int[L];
			for(int i=0;i<L;i++){
				a[i]=in.nextInt();				
			}
			System.out.println(numberOfSwaps(a));
			T--;
		}

	}
	public static int numberOfSwaps(int[] a){
		int count=0;
		for(int i=0;i<a.length;i++){
			int temp=a[i];
			int j=i;
			while(j>0&&temp<a[j-1]){
				a[j]=a[j-1];
				j=j-1;
				count++;
			}
			a[j]=temp;
		}
		return count;
	}
}