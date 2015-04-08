import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test1 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<N;i++){
            builder.append(in.nextLine());
        }
        int T=Integer.parseInt(in.nextLine());
        for(int i=0;i<T;i++){
            String pattern="(\\w+|_)"+in.nextLine()+"(\\w+|_)";
            Pattern pat=Pattern.compile(pattern);
            Matcher mat=pat.matcher(builder.toString());
            int j=0;
            while(mat.find()){
                j++;
            }
            System.out.println(j);
        }
    }
}