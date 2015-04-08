
import java.util.Scanner;
import java.util.Stack;

public class TestClass3
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		Exam e=new Exam(in);
		int[][] a={{0,0,0,0,0},{0,0,2,1,2},{0,2,0,3,10},{0,1,3,0,5},{0,2,10,5,0}};
		ShortPath path=new ShortPath();
		printMatrix(a);
        path.tsp(a);                
		
	}
	public static void printMatrix(int[][] mat)
	{
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[i].length;j++)
			{
				System.out.print(" "+mat[i][j]);
			}
			System.out.println();
		}

	}

}
class Exam
{
	Scanner in;
	int noOfRows;
	int noOfColoum;
	Box[][] arr;
	Vertice[] nodes;
	int size=0;
	int[][] Path;
	public Exam(Scanner in)
	{
		this.in=in;
		this.noOfRows=in.nextInt();
		this.noOfColoum=in.nextInt();
		arr=new Box[noOfColoum][noOfRows];
		Path=new int[30][30];
		getGivenMatrix(arr);
	//	printMatrix(arr,noOfColoum,noOfRows);
		for(int i=0;i<size;i++)
		{
			BFS(arr,nodes[i],noOfColoum,noOfRows);
                        UnVisitingBox(arr);
                        
		}
		
	//	printMatrix(Path,size,size);
	//	printMatrix(adjMatrix());
	}
	public void getGivenMatrix(Box[][] arr)
	{
		int checkPoints=1;
		nodes=new Vertice[30];
		
		int j=0;
		Vertice goal=new Vertice();
		while(in.hasNext())
		{
			String s=in.next();
			char[] c=s.toCharArray();
			for(int i=0;i<c.length;i++)
			{
				if(c[i]=='@')
				{
					nodes[checkPoints]=new Vertice();
					nodes[checkPoints].id=checkPoints;
					arr[j][i]=new Box();
					arr[j][i].Value=(char)(checkPoints+48);					
					nodes[checkPoints].left=i;
					nodes[checkPoints].top=j;
                                        checkPoints++;
					size++;
				}
				else if(c[i]=='S')
				{
					nodes[0]=new Vertice();
					nodes[0].id=0;
					arr[j][i]=new Box();
					arr[j][i].Value='0';
					nodes[0].left=i;
					nodes[0].top=j;
					size++;
				}
				else if(c[i]=='G')
				{
					goal.left=i;
					goal.top=j;
				}
				else
				{
					arr[j][i]=new Box();
					arr[j][i].Value=c[i];
					
				}				
			}
			j++;
		}
                goal.id=checkPoints;                
		nodes[checkPoints]=goal;
		arr[goal.top][goal.left]=new Box();
		arr[goal.top][goal.left].Value=(char)(checkPoints+48);
                size++;
	}
	public void checkingNeighbours(Box[][] arra,Vertice node,LLQueue queue,int col,int row)
	{
		if(node.top-1>=0&&arra[node.top-1][node.left].Value!='#'&&arra[node.top-1][node.left].IsVisited==false)
		{
			arra[node.top-1][node.left].IsVisited=true;
			Vertice newNode=new Vertice();
			newNode.left=node.left;
                        newNode.id=(int)(arra[node.top-1][node.left].Value)-48;
			newNode.top=node.top-1;
			newNode.d=node.d + 1;
			queue.enqueue(newNode);
		}
		if(node.left+1<row&&arra[node.top][node.left+1].Value!='#'&&arra[node.top][node.left+1].IsVisited==false)
		{
			arra[node.top][node.left+1].IsVisited=true;
			Vertice newNode=new Vertice();
			newNode.left=node.left+1;
                        newNode.id=(int)(arra[node.top][node.left+1].Value)-48;
			newNode.top=node.top;
			newNode.d=node.d+1;
			queue.enqueue(newNode);
		}
                if(node.top+1<col&&arra[node.top+1][node.left].Value!='#'&&arra[node.top+1][node.left].IsVisited==false)
		{
			arra[node.top+1][node.left].IsVisited=true;
			Vertice newNode=new Vertice();
			newNode.left=node.left;
                        newNode.id=(int)(arra[node.top+1][node.left].Value)-48;
			newNode.top=node.top+1;
			newNode.d=node.d+1;
			queue.enqueue(newNode);
		}
		if(node.left-1>=0&&arra[node.top][node.left-1].Value!='#'&&arra[node.top][node.left-1].IsVisited==false)
		{
			arra[node.top][node.left-1].IsVisited=true;
			Vertice newNode=new Vertice();
			newNode.left=node.left-1;
                        newNode.id=(int)(arra[node.top][node.left-1].Value)-48;
			newNode.top=node.top;
			newNode.d=node.d+1;
			queue.enqueue(newNode);
		}
		
	}
	public void BFS(Box[][] ar,Vertice seed,int col,int row)
	{
		seed.d=0;
                ar[seed.top][seed.left].IsVisited=true;
		LLQueue q=new LLQueue();
		q.enqueue(seed);
		while(!q.IsEmpty())
		{
                    Vertice node=q.dequeue();
			if(ar[node.top][node.left].Value!='.'&&ar[node.top][node.left].Value!='@')
			{                            
				Path[seed.id][(int)(arr[node.top][node.left].Value)-48]=node.d;				
                        }
			checkingNeighbours(ar,node,q,col,row);
		}
	}
        public void UnVisitingBox(Box[][] array)
        {
            for(int i=0;i<array.length; i++)
            {
                for(int j=0;j<array[i].length;j++)
                {
                    array[i][j].IsVisited=false;
                }
            }
        }
	public void printMatrix(Box[][] mat,int row,int col)
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(mat[i][j]==null){ return; }
				System.out.print(" "+mat[i][j].Value);
			}
			System.out.print("\n");
		}
	}
	public void printMatrix(int[][] mat,int row,int col)
	{
		for(int i=0;i<col;i++)
		{
			for(int j=0;j<row;j++)
			{
				System.out.print(" "+mat[i][j]);
			}
			System.out.print("\n");
		}
	}
	public int[][] adjMatrix()
	{
        int[][] adj=new int[size+1][size+1];
		for(int i=1;i<=size;i++)
		{
			for(int j=1;j<=size;j++)
			{
				adj[i][j]=Path[i-1][j-1];
			}
		}
        return adj;
	}
	public void printMatrix(int[][] mat)
	{
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[i].length;j++)
			{
				System.out.print(" "+mat[i][j]);
			}
			System.out.println();
		}

	}


}
class ShortPath
{
       private int numberOfNodes;
       private Stack<Integer> stack;
       public ShortPath()
       {
        stack = new Stack<Integer>();           
       }
 
    public void tsp(int adjacencyMatrix[][])
    {
		if(adjacencyMatrix.length==3)
		{
			System.out.println("Minimum steps from START to GOAL is: "+adjacencyMatrix[1][2]);
			return;
		}
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
            i = 1;
            min = Integer.MAX_VALUE;
            while (i <numberOfNodes)
            {
                if (adjacencyMatrix[element][i]!=0&& visited[i] == 0)
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
}
class Box
{
	public char Value;
	public boolean IsVisited;
}
class Vertice
{
	public int d;
	public int id;
	public int left;
	public int top;
        
        public Vertice()
        {
            id=-1;
            d=0;
        }
}
class LLQueue
{
	private LinkNode front;
	private LinkNode rear;
	public LLQueue()
	{
		front=null;
		rear=null;
	}
	public void enqueue(Vertice data)
	{
            if(data==null){ return;}
		LinkNode node=new LinkNode(data);
		if(rear!=null)
		{
			rear.setNextNode(node);
		}
		rear=node;
		if(front==null)
		{
			front=rear;
		}	
	}
	public Vertice dequeue()
	{
		if(front==null)
		{
			return null;
		}
		LinkNode temp=front;
		front=front.getNextNode();
		temp.setNextNode(null);
		return temp.getData();
	}
	public Vertice peek()
	{
		if(front==null)
		{
			return null;
		}
		return front.getData();
	}
	public boolean IsEmpty()
	{
		if(front==null)
		{
			return true;
		}
		return false;
	}
}
class LinkNode
{
	private Vertice data;
	private LinkNode node;
	public LinkNode(Vertice data)
	{
		this.data=data;
	}
	public Vertice getData()
	{
		return data;
	}
	public void setData(Vertice data)
	{
		this.data=data;
	}
	public LinkNode getNextNode()
	{
		return node;
	}
	public void setNextNode(LinkNode node)
	{
		this.node=node;
	}
}