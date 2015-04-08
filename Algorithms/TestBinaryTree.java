public class TestBinaryTree
{
	public static void main(String[] args)
	{
		BinaryTree treeOne=new BinaryTree();
		BinaryTree treeTwo=new BinaryTree();
		BinaryTreeNode root1=treeOne.createTreeOne();
		BinaryTreeNode root2=treeTwo.createTreeTwo();
		System.out.print("\nprint tree one of size "+treeOne.height(root1)+" InOrder: ");		
		treeOne.printInOrder(root1);
		System.out.print("\nprint tree two of size "+treeTwo.height(root2)+" PreOrder: ");		
		treeOne.printPreOrder(root1);
		System.out.println("\nIs tree one and tree two are identical: "+isIdentical(root1,root2));
		treeOne.rootToleafSum(root1);
		int[] in={4,2,5,1,6,3,7};
		int[] pre={1,2,4,5,3,6,7};
		BinaryTreeNode rootfour=makeTree(in,pre,0,in.length,0);
		treeOne.printLevelOrder(rootfour);
	}
	private static BinaryTreeNode makeTree(int[] inorder,int[] preorder,int start,int end,int key)
	{
			if(start>end)
			{
				return null;
			}			
			int index=findIndex(inorder,preorder[key]);
			BinaryTreeNode node=new BinaryTreeNode(inorder[index]);
			if(start==end)
			{
				return node;
			}
			node.setLeftNode(makeTree(inorder,preorder,start,index,key));
			node.setRightNode(makeTree(inorder,preorder,index,inorder.length,key));
			return node;		
	}
	private static int findIndex(int[] arr,int key)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==key)
			{
				return i;
			}
		}
		return -1;
	}
	private static boolean isIdentical(BinaryTreeNode t1,BinaryTreeNode t2)
	{
		if(t1==null&t2==null)
		{
			return true;
		}
		if(t1==null||t2==null)
		{
			return false;
		}
		return (t1.getData()==t2.getData())&&isIdentical(t1.getLeftNode(),t2.getLeftNode())&&isIdentical(t1.getRightNode(),t2.getRightNode());
	}
	private static void deleteTree(BinaryTreeNode root)
	{
		if(root==null)
		{
			return;
		}
		deleteTree(root.getLeftNode());
		deleteTree(root.getRightNode());
		root.setLeftNode(null);
		root.setRightNode(null);
	}
}

class BinaryTree
{
	private BinaryTreeNode root;
	private boolean isLeft;
	private boolean isRootset;
	public BinaryTreeNode getRoot()
	{
		return root;
	}
	public BinaryTree()
	{
		root=null;
		isLeft=true;
		isRootset=false;
	}
	public BinaryTreeNode createTreeTwo()
	{
		BinaryTreeNode e4=new BinaryTreeNode(4);
		BinaryTreeNode e5=new BinaryTreeNode(5);
		BinaryTreeNode e6=new BinaryTreeNode(6);		
		BinaryTreeNode e7=new BinaryTreeNode(7);		
		BinaryTreeNode e2=new BinaryTreeNode(2,e4,e5);
		BinaryTreeNode e3=new BinaryTreeNode(3,e6,e7);
		BinaryTreeNode e1=new BinaryTreeNode(1,e2,e3);
		
		root=e1;
		return e1;		
	}
	public BinaryTreeNode createTreeOne()
	{

		BinaryTreeNode e14=new BinaryTreeNode(14);
		BinaryTreeNode e13=new BinaryTreeNode(13);
		BinaryTreeNode e12=new BinaryTreeNode(12);		
		BinaryTreeNode e11=new BinaryTreeNode(11);		
		BinaryTreeNode e10=new BinaryTreeNode(10);
		BinaryTreeNode e9=new BinaryTreeNode(9);
		BinaryTreeNode e8=new BinaryTreeNode(8);		
		BinaryTreeNode e4=new BinaryTreeNode(4);
		BinaryTreeNode e5=new BinaryTreeNode(5);
		BinaryTreeNode e6=new BinaryTreeNode(6);		
		BinaryTreeNode e7=new BinaryTreeNode(7);		
		BinaryTreeNode e2=new BinaryTreeNode(2,e4,e5);
		BinaryTreeNode e3=new BinaryTreeNode(3,e6,e7);
		BinaryTreeNode e1=new BinaryTreeNode(1,e2,e3);
		
		root=e1;
		return e1;
	}
	public void printPreOrder(BinaryTreeNode root)
	{
		if(root==null)
		{
			return;
		}
		System.out.print(root.getData()+" ");
		printPreOrder(root.getLeftNode());
		printPreOrder(root.getRightNode());
	}
	public void printInOrder(BinaryTreeNode root)
	{
		if(root==null)
		{
			return;
		}
		printInOrder(root.getLeftNode());
		System.out.print(root.getData()+" ");
		printInOrder(root.getRightNode());		
	}
	public void printPostOrder(BinaryTreeNode root)
	{
		if(root==null)
		{
			return;
		}
		printPostOrder(root.getLeftNode());
		printPostOrder(root.getRightNode());
		System.out.print(root.getData()+" ");
	}
	public void printLevelOrder(BinaryTreeNode root)
	{
		if(root==null)
		{
			System.out.println("tree is empty");
			return;
		}
		Queue<BinaryTreeNode> q=new Queue<BinaryTreeNode>();
		q.enqueue(root);
		while(!q.IsEmpty())
		{
			BinaryTreeNode node=q.dequeue();
			System.out.print(node.getData()+" ");
			if(node.getLeftNode()!=null)
			{
				q.enqueue(node.getLeftNode());
			}
			if(node.getRightNode()!=null)
			{
				q.enqueue(node.getRightNode());
			}
		}
	}
	public int size(BinaryTreeNode node)
	{
		if(node==null)
		{
			return 0;
		}
		return size(node.getLeftNode())+size(node.getRightNode())+1;
	}
	private int height=-1;	
	public int height(BinaryTreeNode node)
	{
		findHeight(node,0);
		return height;
	}
	private void findHeight(BinaryTreeNode node,int k)
	{
		if(node==null)
		{
			if(height<k)
			{
				height=k;
			}
			return;
		}
		findHeight(node.getLeftNode(),k+1);
		findHeight(node.getRightNode(),k+1);
	}
	public void deleteTree(BinaryTreeNode root)
	{
		if(root==null)
		{
			return;
		}
		deleteTree(root.getLeftNode());
		deleteTree(root.getRightNode());
		root.setLeftNode(null);
		root.setRightNode(null);
	}
	public void spiralTraverse(BinaryTreeNode root)
	{
		Stack<BinaryTreeNode> s1=new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> s2=new Stack<BinaryTreeNode>();
		s1.push(root);
		while(!s1.isEmpty()||!s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				BinaryTreeNode node=s1.pop();
				System.out.print(node.getData()+" ");
				if(node.getLeftNode()!=null)
				{
					s2.push(node.getLeftNode());
				}
				if(node.getRightNode()!=null)
				{
					s2.push(node.getRightNode());					
				}
			}
			while(!s2.isEmpty())
			{
				BinaryTreeNode node=s2.pop();
				System.out.print(node.getData()+" ");				
				if(node.getRightNode()!=null)
				{
					s1.push(node.getRightNode());
				}
				if(node.getLeftNode()!=null)
				{
					s1.push(node.getLeftNode());
				}
			}
		}
		}
		int sum=0;
		public void rootToleafSum(BinaryTreeNode root)
		{
			if(root==null)
			{
				return;				
			}
			if(root.getLeftNode()==null&&root.getRightNode()==null)
			{
				System.out.print(sum+root.getData()+" ");
				sum=0;
			}
			sum=sum+root.getData();
			rootToleafSum(root.getLeftNode());
			rootToleafSum(root.getRightNode());
		}
	
}
class BinaryTreeNode
{
	private int data;
	private BinaryTreeNode leftNode;
	private BinaryTreeNode rightNode;
	public BinaryTreeNode(int data)
	{
		this.data=data;
		leftNode=null;
		rightNode=null;
	}
	public BinaryTreeNode(int data,BinaryTreeNode left,BinaryTreeNode right)
	{
		this.data=data;
		leftNode=left;
		rightNode=right;
	}
	public int getData()
	{
		return data;
	}
	public void setData(int data)
	{
		this.data=data;
	}
	public void setLeftNode(BinaryTreeNode node)
	{
		this.leftNode=node;
	}
	public BinaryTreeNode getLeftNode()
	{
		return this.leftNode;
	}
	public void setRightNode(BinaryTreeNode node)
	{
		this.rightNode=node;
	}
	public BinaryTreeNode getRightNode()
	{
		return rightNode;
	}
}
class Stack<T>
{
	private ListNode<T> top;
	
	public Stack()
	{
		top=null;
	}
	public void push(T node)
	{
		ListNode<T> elm=new ListNode<T>(node);
		if(top==null)
		{
			top=elm;
			elm.setNextNode(null);
			return;
		}
		elm.setNextNode(top);
		top=elm;
		elm=null;
	}
	public T pop()
	{
		if(top==null)
		{
			System.out.println("Stack is Empty");
			return null;
		}
		ListNode<T> temp=top;
		top=top.getNextNode();
		temp.setNextNode(null);
		return temp.getData();		
	}
	public T getTop()
	{
		return top.getData();
	}
	public boolean isEmpty()
	{
		if(top==null)
		{
			return true;
		}
		return false;
	}
}
class Queue<T>
{
	private ListNode<T> front;
	private ListNode<T> rear;
	public Queue()
	{
		front=null;
		rear=null;
	}
	public void enqueue(T data)
	{
		ListNode<T> node=new ListNode<T>(data);
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
	public T dequeue()
	{
		if(front==null)
		{
			System.out.println("Stack is Empty");
			return null;
		}
		ListNode<T> temp=front;
		front=front.getNextNode();
		temp.setNextNode(null);
		return temp.getData();
	}
	public boolean IsEmpty()
	{
		if(front==null)
		{
			return true;
		}
		return false;
	}
	public T getTop()
	{
		return front.getData();
	}
}
class ListNode<T>
{
	private T data;
	private ListNode<T> node;
	public ListNode(T data)
	{
		this.data=data;
	}
	public T getData()
	{
		return data;
	}
	public ListNode<T> getNextNode()
	{
		return node;
	}
	public void setNextNode(ListNode<T> node)
	{
		this.node=node;
	}
	public void setData(T data)
	{
		this.data=data;
	}
}