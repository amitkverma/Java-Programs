/* Almost Sorted */
import java.util.Scanner;

public class AlmostSorted	
{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int L=in.nextInt();
		int[] a=new int[L];
		for(int i=0;i<L;i++){
			a[i]=in.nextInt();
		}
		findingAlmostSorted(a);
	}
	public static void findingAlmostSorted(int[] a){
		int i=0;
		int j=a.length-1;
		while(i<j){
			if(isSorted(a,i,j)){
				System.out.println("yes");
				break;
			}else{
				if(isCorrectPostion(a,i)){
					i++;
					continue;
				}else{
					if(isCorrectPostion(a,j)){
						j--;
						continue;
					}else{						
						swap(a,i,j);
						if (isSorted(a,0,a.length-1)) {
							System.out.println("yes");
							System.out.println("swap "+(i+1)+" "+(j+1));
							break;
						}else{
							swap(a,i,j);
							reverse(a,i,j);
							if(isSorted(a,0,a.length-1)){
								System.out.println("yes");
								System.out.println("reverse "+(i+1)+" "+(j+1));
								break;								
							}else{
								System.out.println("no");
								break;
							}
						}

					}
				}
			}

		}
	}
	public static void reverse(int[] a,int m,int n){
		while(m!=n&&m<n&&n>0&&m<a.length){
			swap(a,m,n);
			m++;
			n--;
		}
	}
	public static void swap(int[] a,int m,int n){
		int temp=a[m];
		a[m]=a[n];
		a[n]=temp;
	}
	public static boolean isSorted(int[] a,int m,int n){
		boolean flag=true;
		for(int i=m;i<n;i++){
			if(i<a.length-1&&a[i]>a[i+1]){
				flag=false;
			}
		}
		return flag;
	}
	public static boolean isCorrectPostion(int[] a,int pos){
		boolean flag=true;
		int value=a[pos];
		int temp1=pos-1;
		int temp2=pos+1;
		while(temp1>=0){
			if(a[temp1]>value){
				flag=false;
			}
			temp1--;
		}
		while(temp2<a.length){
			if(a[temp2]<value){
				flag=false;
			}

			temp2++;
		}
		return flag;
	}
	public static void printArray(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
}