/* This is a java program to encrypt a matrix using a key. The key is hidden and kept secret and inverse copy of the key is provided to the receiver, with which he/she can decrypt the matrix. The operation performed is matrix multiplication. */

import java.util.Scanner;

public class Inverse_Matrix
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Please Enter the Dimension of matrix");
		int a=in.nextInt();
		int b=in.nextInt();
		int[][] mat=new int[a][b];
		for(int i=0;i<a;i++){
			for(int j=0;j<b;j++){
				mat[i][j]=in.nextInt();
			}
		}
		printMatrix(mat);
		printMatrix(transposeMatrix(mat));
	}
	public static int determinant(int[][] mat,int count){
		if(mat.length==2&&mat[0].length==2){
			count++;
			if(count%2==0){
				return (-1)*determinant2x2(mat);	
			}else{
				return determinant2x2(mat);				
			}
		}
		for(int i=0;i<mat[0].length;i++){
			int[][] temp=new int[mat.length-1][mat[0].length]
		}
	}
	private static int determinant2x2(int[][]  mat){
		int	result=mat[0][0]*mat[1][1]-mat[1][0]*mat[0][1];
		return result;
	}
	public static int[][] transposeMatrix(int[][] mat){
		int l=mat.length;
		int m=mat[0].length;
		int[][] result=new int[m][l];
		for(int i=0;i<l;i++){
			for(int j=0;j<m;j++){
				result[j][i]=mat[i][j];
			}
		}
		return result;
	}
	public static void printMatrix(int[][] mat){
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
}