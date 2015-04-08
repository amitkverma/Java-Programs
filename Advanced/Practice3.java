import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Practice3 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        while(T>0){
            int n=in.nextInt();
            int a=in.nextInt();
            int b=in.nextInt();
            int f=0;
            int l=0;
            if (a<b){
                f=(n-1)*a;
                l=(n-1)*b;                
            }else{
                f=(n-1)*b;
                l=(n-1)*a;
            }
            System.out.println(f+"  "+l);
            int d=takeDiff(n,f,l);
            for(int i=1;i<=n;i++){
                int result=f+(i-1)*d;
            //    System.out.print(result+" ");
            }
            System.out.print("\n");
            T--;
        }
        
    }
    public static int takeDiff(int n,int f,int l){
        return (l-f)/(n-1);
    }
}