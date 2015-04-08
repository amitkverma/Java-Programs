public class Test
{
	public static void main(String[] args)
	{
		A a=new B();
		a.fun();
	}
}
class A 
{
   static void fun() 
   {
      System.out.println("A.fun()");
   }
}
 
class B extends A 
{ 
   static void fun() {   
      System.out.println("B.fun()");
   }
}

class Vertice
{
	public int d;
	public int id;
	public int left;
	public int top;
	public Vertice(int k)
	{
		left=k;
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
		LinkNode node=new LinkNode(data);
		if(rear!=null)
		{
			rear.setNextNode(node);
		}
		rear=node;
		if(front==null)
		{
			front=node;
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