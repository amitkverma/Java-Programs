/* Almost sorted intervals */
import java.util.Scanner;

public class AlmostSortedInterval
{
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int L=in.nextInt();
		int[] a=new int[L];
		for(int i=0;i<L;i++){
			a[i]=in.nextInt();
		}
		System.out.println(countAlmostSorted(a));
	}
	public static int countAlmostSorted(int[] a){
		int count=0;		
		for(int i=0;i<a.length;i++){
			int j=i;
			while(j<a.length-1&&a[j]<a[j+1]){
				j=j+1;
				count++;
			}
			count++;
		}
		return count;
	}
}