
import java.io.*;
import java.util.Scanner;

public class TestCase2
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		Experiment a=new Experiment(in);
	}
}
class Experiment
{
	Scanner in;
	int noOfRows;
	int noOfColoum;
	int[][] givenMatrix;
	public Experiment(Scanner in)
	{
		this.in=in;
	}
	public int getVertices()
	{
		int vertice=0;
		noOfRows=in.nextInt();
		noOfColoum=in.nextInt();
		givenMatrix=new int[noOfRows-2][noOfColoum-2];
		int j=0;
		in.next();
		while(in.hasNext())
		{
			String s=in.next();
			char[] c=s.toCharArray();
			for(int i=0;i<c.length-1;i++)
			{
				if(c[i+1]=='.')
				{
					givenMatrix[j][i]=1;
					vertices++;
				}
				if(c[i+1]=='S')
				{
					givenMatrix[j][i]=1;
					vertices++;
				}
				if(c[i+1]=='@')
				{
					givenMatrix[j][i]=1;
					vertices++;
				}
				if(c[i+1]=='G')
				{
					givenMatrix[j][i]=1;
					vertices++;
				}
			}
			if(j==noOfRows-3)
			{
				break;
			}
			j++;
		}		
		printMatrix(givenMatrix);
		return vertice;
	}
	public void printMatrix(int[][] mat)
	{
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[i].length;j++)
			{
				System.out.print(" "+mat[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public int[][] getAdjMatrix(int vertices)
	{
		int[][] adjMatrix=new int[vertices][vertices];
		for(int i=0;i<adjMatrix.length;i++)
		{
			for(int j=0;j<adjMatrix[i].length;j++)
			{
				if(i==j)
				{
					a[i][j]=0;					
				}
				else
				{
					
				}
			}
		}
	}
	
}
