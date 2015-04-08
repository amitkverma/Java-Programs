import java.util.Scanner;

public class BubleSort
{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int S=in.nextInt();
		int[] a=new int[S];
		for(int i=0;i<S;i++){
			a[i]=in.nextInt();
		}
		System.out.println("Before: ");
		printArray(a);
		System.out.println("After: ");
		bubleSort(a);
		printArray(a);

	}
	public static void bubleSort(int[] a){
		int n=a.length-1;
		for(int i=n-1;i>0;i--){
			for(int j=0;j<=i;j++){
				if(a[j]>a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}

		}
	}
	public static void printArray(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.print("\n");
	}

}