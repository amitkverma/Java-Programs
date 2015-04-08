/*  Mark and Toys */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MarkAndToys {
    public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt();
        int k=stdin.nextInt();
        int prices[]=new int[n];
        for(int i=0;i<n;i++) prices[i]=stdin.nextInt();
        quickSort(prices,0,prices.length-1);
        printArray(prices);
        long sum=0;
        int i=0;
        while(sum<=k){
            sum=sum+prices[i];
            i++;
        }
        int Answer=i-1;
        System.out.println(Answer);
    }

    public static void quickSort(int[] a,int f,int l){
        if(l>f){
            int pivot=findPivot(a,f,l);
            quickSort(a,f,pivot-1);
            quickSort(a,pivot+1,l);            
        }
    }
    public static int findPivot(int[] a,int f,int l){
        int pivot=f;
        int pivotData=a[pivot];
        int i=f;
        int j=l;
        while(i<a.length&&j>=0){
            while(i<a.length&&pivotData<=a[i]){
                i++;
            }
            while(j>=0&&pivotData>a[j]){
                j--;
            }
            if(i<j){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;                
            }else{
                a[f]=a[j];
                a[j]=pivotData;
                pivot=j;
                break;
            }
        }
        return pivot;
    }
    public static void printArray(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);            
        }
    }
}
