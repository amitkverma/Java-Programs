import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Practice2 {

    public static void main(String[] args) throws Exception {
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        while(T>0){
            System.out.println(noPieces(in.nextInt()));
            T--;
        }
        
    }
    public static long noPieces(int n){
        long i=0L;
        if(n%2==0){
            int v=n/2;
            i=(long)v*v;
        }else{
            int v=n/2;
            i=(long)(v+1)*v;
        }
        return i;
    }
}