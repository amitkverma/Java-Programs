import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Practice1 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(reader.readLine());
        while(T>0){
            char[] in=reader.readLine().toCharArray();
            int l=in.length-1;
            while(isPalindrome(in)!=true&&l>=0){
                if((int)in[l]>97&&(int)in[l]<123){
                    int value=(int)in[l]-1;
                    System.out.println((char)value);
                    in[l]=(char)value;
                }
                else{

                    l--;                    
                }
            }
            T--; 
        } 
    }
    public static boolean isPalindrome(char[] a){
        boolean isPalin=true;
        int i=0;
        int j=a.length-1;
        while(true){
            if(a[i]!=a[j]){

               isPalin=false;
            }
            i++;
            j--;
            if(i==j){
                break;
            }
        }
        return isPalin;
    }
}