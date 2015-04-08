/* Make it Anagram */

import java.util.Scanner;

public class MakeAnagram
{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String s1=in.nextLine();
		String s2=in.nextLine();
		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();
		int[] a1=new int[123];
		int[] a2=new int[123];
		for(int i=0;i<c1.length;i++){
			a1[(int)c1[i]]=a1[(int)c1[i]]+1;
		}
		for(int i=0;i<c2.length;i++){
			a2[(int)c2[i]]=a2[(int)c2[i]]+1;
		}
		int noOfDelete=0;
		for(int i=97;i<123;i++){
			if(a1[i]!=a2[i]){
				int value=a1[i]-a2[i];
				if(value>0){
					noOfDelete=noOfDelete+value;
				}else{
					noOfDelete=noOfDelete-value;
				}
			}
		}
		System.out.print(noOfDelete);
	}

}