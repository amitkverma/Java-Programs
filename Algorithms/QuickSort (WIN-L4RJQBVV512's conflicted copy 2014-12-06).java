import java.util.Scanner;

public class QuickSort
{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int S=in.nextInt();
		int[] A=new int[S];
		for(int i=0;i<S;i++)
			A[i]=in.nextInt();
		System.out.println("Before: ");
		printArray(A);
		System.out.println("After: ");
		quickSort(A,0,A.length-1);
		printArray(A);
	}
	public static void quickSort(int[] A,int beg,int end){
		if(end>beg){
			int pivot=Partition(A,beg,end);
			quickSort(A,beg,pivot-1);
			quickSort(A,pivot+1,end);
		}
	}
	public static int Partition(int[] A,int beg,int end){
		int pivot=A[beg];
		int i=beg;
		int j=end;
		while(i<j){
			while(A[i]<=pivot&&i<end){
				i++;
			}
			while(A[j]>pivot&&j>beg){
				j--;
			}
			if(i<j){
				int temp=A[i];
				A[i]=A[j];
				A[j]=temp;
			}
		}
		A[beg]=A[j];
		A[j]=pivot;
		return j;
	}
	public static void printArray(int[] A ){
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]+" ");
		}
		System.out.print("\n");
	}
}