/* Sansa and XOR */

import java.util.Scanner;

public class SansaXor
{
public static void main(String[] args){
	Scanner in=new Scanner(System.in);
	int T=in.nextInt();
	while(T>0){
		int N=in.nextInt();
		int[] a=new int[N];
		for(int i=0;i<a.length;i++){
			a[i]=in.nextInt();
		}
		sansaXor(a);
		T--;
	}
}
public static void sansaXor(int[] a){
	int xor=0;
	if(a.length%2!=0){
		for(int i=0;i<a.length;i++){
			if(i%2==0){
				xor=xor^a[i];
			}
		}
	}else{
		xor=0;
	}
	System.out.print(xor);

}
}