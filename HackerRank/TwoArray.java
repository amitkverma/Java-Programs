/* Two arrays */

import java.util.Scanner;

public class TwoArray
{
	public static void main(String[] args){		
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int j=0;j<T;j++){
			int N=in.nextInt();
			int K=in.nextInt();
			int[] a1=new int[N];
			int[] a2=new int[N];
			for(int i=0;i<N;i++){
				a1[i]=in.nextInt();
			}
			for(int i=0;i<N;i++){
				a2[i]=in.nextInt();
			}

			Sort(a1);
			Sort(a2);
			System.out.println(findResult(a1,a2,K));
		}
	}
	public static boolean findResult(int[] a1,int[] a2,int K){
		int i=0;
		int j=a1.length-1;

		while(j>=0&&i<a1.length){
			int value=a2[j];
			while(value+a1[i]<K){
				if(i<a1.length-2){
					i++;
				}else{
					return false;
				}
			}
			i++;
			j--;
		}
		if(i>=a1.length&&j>=0){
			return false;
		}
		return true;
	}
	public static void Sort(int[] a){
		quickSort(a,0,a.length-1);
	}
	public static void quickSort(int[] a,int init,int end){
		if(end>init){
			int pivot=findPivot(a,init,end);
			quickSort(a,init,pivot-1);
			quickSort(a,pivot+1,end);
		}
	}
	public static int findPivot(int[] a,int init,int end){
		int pivot=a[init];
		int pivotloc=init;
		int i=init;
		int j=end;
		while(true){
			while(a[i]<=pivot&&i>a.length-1){
				i++;
			}
			while(a[j]>pivot&&j>0){
				j--;
			}
			if(i>j){
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}else{
				a[init]=a[j];
				a[j]=pivot;
				pivotloc=j;
				break;
			}
		}
		return pivotloc;
	}
	public static void printArray(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.print("\n");
	}
}