/* Insertion Sort */

import java.util.Scanner;

public class InsertionSort
{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int S=in.nextInt();
		int[] ar=new int[S];
		int i=0;
		while(i<S){
			ar[i]=in.nextInt();
			i++;
		}
		System.out.println(insertionsort(ar));
	}
	public static int insertionsort(int[] ar){
		int count=0;
		for(int i=1;i<ar.length;i++){
			int v=ar[i];
			int j=i;

			while(ar[j-1]>v&&j>0){
				ar[j]=ar[j-1];
				j--;
				count++;
				if(j<=0){
					break;
				}	
			}
			ar[j]=v;			
		}
		return count;
	}
	public static void printArray(int[] ar){
		for(int i=0;i<ar.length;i++){
			System.out.print(ar[i]+" ");
		}
		System.out.println("\n");
	}
}