import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
 
public class TSPNearestNeighbour
{
    private int numberOfNodes;
    private Stack<Integer> stack;
 
    public TSPNearestNeighbour()
    {
        stack = new Stack<Integer>();
    }
	public static <T>void print(T n){
		System.out.print(n);
	}
	public static void printMatrix(int mat[][], int n){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
    public void tsp(int adjacencyMatrix[][])
    {
		int sum=0;
		int lastdst=0;
        numberOfNodes = adjacencyMatrix[1].length - 1;
        int[] visited = new int[numberOfNodes+1];
        visited[1] = 1;
        stack.push(1);
        int element, dst = 0, i;
        int min = Integer.MAX_VALUE;
        boolean minFlag = false;
        System.out.print("[START]-->");
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = 0;
            min = Integer.MAX_VALUE;
            while (i < numberOfNodes)
            {
                if (adjacencyMatrix[element][i] > 1 && visited[i] == 0)
                {
                    if (min > adjacencyMatrix[element][i])
                    {						
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag)
            {
                visited[dst] = 1;
                stack.push(dst);
				sum=sum+adjacencyMatrix[element][dst];
                System.out.print(adjacencyMatrix[element][dst]+"-->["+dst + "]-->");
                minFlag = false;
				lastdst=dst;
                continue;
            }
            stack.pop();
        }
		sum=sum+adjacencyMatrix[numberOfNodes][lastdst];
		System.out.print(adjacencyMatrix[numberOfNodes][lastdst]+"-->[GOAL]\n");
		System.out.println("Minimum steps from START to GOAL is: "+sum);
    }
 
    public static void main(String... arg)
    {
        int number_of_nodes;
        Scanner scanner = null;
        try
        {
            // System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_of_nodes = scanner.nextInt();
            int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
            // System.out.println("Enter the adjacency matrix");
            for (int i = 1; i <= number_of_nodes; i++)
            {
                for (int j = 1; j <= number_of_nodes; j++)
                {
                    adjacency_matrix[i][j] = scanner.nextInt();
                }
            }
			printMatrix(adjacency_matrix, number_of_nodes + 1);
			print("\n");
            for (int i = 1; i <= number_of_nodes; i++)
            {
                for (int j = 1; j <= number_of_nodes; j++)
                {
                    if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0)
                    {
                        adjacency_matrix[j][i] = 1;
                    }
                }
            }
            TSPNearestNeighbour tspNearestNeighbour = new TSPNearestNeighbour();
            tspNearestNeighbour.tsp(adjacency_matrix);
        } catch (InputMismatchException inputMismatch)
         {
             System.out.println("Wrong Input format");
         }
        scanner.close();
    }
}