import java.util.Scanner;

public class MergeSort
{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int S=in.nextInt();
		int[] A=new int[S];
		int[] temp=new int[S];
		for(int i=0;i<S;i++){
			A[i]=in.nextInt();
			temp[i]=0;
		}
		System.out.println("Before: ");
		printArray(A);
		System.out.println("After: ");
		mergeSort(A,temp,0,A.length-1);
		printArray(A);		
	}
	public static void mergeSort(int[] A,int[] temp,int beg,int end){
		if(end>beg){
			int mid=(end+beg)/2;
			mergeSort(A,temp,beg,mid);
			mergeSort(A,temp,mid+1,end);
			merge(A,temp,beg,mid+1,end);
		}
	}
	public static void merge(int[] A,int[] temp,int beg,int mid,int end){
		int left_i=beg;
		int left_j=mid-1;
		int right_i=mid;
		int right_j=end;
		int i=0;
		int size=beg-end+1;
		while(left_i<left_j&&right_i<right_j){
			if(A[left_i]<=A[right_i]){
				temp[i]=A[left_i];
				i++;
				left_i++;
			}else{
				temp[i]=A[right_i];
				i++;
				right_i++;
			}
		}
		while(left_i<=left_j){
			temp[i]=A[left_i];
			left_i++;
			i++;
		}
		while(right_i<=right_j){
			temp[i]=A[right_i];
			right_i++;
			i++;
		}
		for(int j=0;j<=size;j++){
			A[end]=temp[end];
			end--;
		}
	}
	public static void printArray(int[] A){
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]+" ");			
		}
		System.out.print("\n");
	}
}