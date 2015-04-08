/* Cipher */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cipher
{
	public static void main(String[] args) throws Exception{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String[] input=reader.readLine().split(" ");
		int N=Integer.parseInt(input[0]);
		int K=Integer.parseInt(input[1]);
		int temp=K;
		String value=reader.readLine();
		while(temp>0){
			value=value+"0";
			temp--;
		}
		int realvalue=Integer.parseInt(value,2);
		for(int i=1;i<K;i++){
			int d=(int)Math.pow(2,i);
			int t=realvalue/d;
			realvalue=realvalue^t;
		}
		System.out.println(Integer.toBinaryString(realvalue));
	}
}