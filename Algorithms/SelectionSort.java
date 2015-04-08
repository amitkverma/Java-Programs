import java.util.Scanner;

public class SelectionSort
{
	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		int S=in.nextInt();
		int[] a=new int[S];
		for(int i=0;i<S;i++)
			a[i]=in.nextInt();
		System.out.println("Before: ");
		printArray(a);
		System.out.println("After: ");
		selectionSort(a);
		printArray(a);
	}
	public static void selectionSort(int[] A){
		for(int i=0;i<A.length;i++){
			int min=A[i];
			int temp=i;
			for(int j=i;j<A.length;j++){
				if(A[j]<min){
					min=A[j];
					temp=j;
				}				
			}
			A[temp]=A[i];
			A[i]=min;
		}
	}
	public static void printArray(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.print("\n");
	}
}