/* QuickSort */
import java.util.Scanner;

public class QuickSort
{
	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		int S=in.nextInt();
		int[] a=new int[S];
		for(int i=0;i<S;i++){
			a[i]=in.nextInt();
		}
		quickSort(a,0,S-1);
		printArray(a);
	}
	public static void quickSort(int[] ar,int beg,int end){
		if(end>beg){
			int pivot=findPivot(ar,beg,end);
			quickSort(ar,beg,pivot-1);
			quickSort(ar,pivot+1,end);
		}
	}
	public static int findPivot(int[] ar,int beg, int end){
		int pivot=ar[beg];
		int i=beg;
		int j=end;
		while(i<j){
			while(ar[i]<=pivot&&i<end){
				i++;			
			}
			while(ar[j]>pivot&&j>beg){
				j--;
			}

			if(i<j){
				int temp=ar[i];
				ar[i]=ar[j];
				ar[j]=temp;				
			}
		}
		ar[beg]=ar[j];
		ar[j]=pivot;
		return j;
	}
	public static void printArray(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println("\n");
	}
}