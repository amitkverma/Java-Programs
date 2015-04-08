import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(in.readLine());
        while(T>0){
            long value=Long.parseLong(in.readLine());
            long result=(long)(pow(2,value)+1)*2;
            System.out.println(result);
            T--;
        }
        
    }
    public static long pow(int value,long p){
        if(p==0){
            return 1;
        }
        return (long)value*pow(value,p-1);
    }
}
