import java.util.Scanner;

public class InsertionSort
{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int S=in.nextInt();
		int[] A=new int[S];
		for(int i=0;i<S;i++){
			A[i]=in.nextInt();			
		}
		System.out.println("Before: ");
		printArray(A);
		System.out.println("After: ");
		insertionSort(A);
		printArray(A);		
	}
	public static void insertionSort(int[] A){
		for(int i=1;i<A.length;i++){
			int value=A[i];
			int j=i;
			while(A[j-1]>value){
				A[j]=A[j-1];
				j--;
				if(j<=0){
					break;
				}
			}
			A[j]=value;
		}
	}
	public static void printArray(int[] A){
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]+" ");
		}
		System.out.print("\n");
	}
}