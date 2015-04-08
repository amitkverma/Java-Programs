/* Adding element in singly Link list from starting,end and middile */

public class AddingInLinkList
{
	
	public static void main(String[] args)
	{
		LinkList list=new LinkList();
		list.addElement(new LinkNode(5));
		list.addElement(new LinkNode(10));
		list.addElement(new LinkNode(15));
		list.addElement(new LinkNode(20));
		list.addElement(new LinkNode(25));
		list.addElementLast(new LinkNode(3));
		list.addElementLast(new LinkNode(6));
		list.addElementLast(new LinkNode(9));
		list.addElementLast(new LinkNode(12));
		list.addElementLast(new LinkNode(15));
		list.addElement(new LinkNode(2),2);
		list.addElement(new LinkNode(4),4);
		list.addElement(new LinkNode(8),8);
		list.transverseList();		
	}
}
class LinkList
{
	private LinkNode head;
	
	public LinkList()
	{
		head=null;
	}
	public LinkNode getHead()
	{
		return head;
	}
	public void addElement(LinkNode node) // adding element at Begining
	{
		if(node!=null)
		{
			if(head==null) 			// if list is empty
			{
				System.out.println("Creating Link List...");
				System.out.println("Adding Element: "+node.getData()+" on List..");
				node.setNextNode(null);
				head=node;
			}
			else
			{
				System.out.println("Adding Element: "+node.getData()+ " on List..");
				node.setNextNode(head);
				head=node;
			}			
		}
	}
	public void addElement(LinkNode node,int position) // adding element at a given position
	{
		int l=listLength();
		
		if(node!=null&&position>=1)
		{
			if(l<position)
			{
				System.out.println("Please enter a valid position");
				return;
			}
			if(head==null)
			{
				System.out.println("Creating Link List..");
				System.out.println("Adding Element: "+node.getData()+" on List..");
				head=node;
				node.setNextNode(null);
				return;
			}
			System.out.println("Adding Element: "+node.getData()+" at "+position+" on List..");
			int k=0;
			LinkNode currentNode=head;
			while(k<position)
			{
				k++;
				currentNode=currentNode.getNextNode();
			}
			node.setNextNode(currentNode.getNextNode());
			currentNode.setNextNode(node);
		}
	}
	public int listLength()
	{
		LinkNode currentElement=head;
		int k=0;
		while(currentElement.getNextNode()!=null)
		{
			currentElement=currentElement.getNextNode();
			k++;
		}
		return k;
	}
	
	public void addElementLast(LinkNode node)
	{
		if(node!=null)
		{
			if(head==null)
			{
				System.out.println("Creating Link List..");
				System.out.println("Adding Element: "+node.getData()+" on List..");
				head=node;
				node.setNextNode(null);
				return;
			}
			System.out.println("Adding Element :"+node.getData()+" on List..");
			LinkNode currentNode=head;
			while(currentNode.getNextNode()!=null)
			{
				currentNode=currentNode.getNextNode();
			}
			currentNode.setNextNode(node);
			node.setNextNode(null);
		}	
	}
	public void transverseList()
	{
		LinkNode currentNode=head;
		while(currentNode!=null)
		{
			System.out.print(currentNode.getData()+"->");
			currentNode=currentNode.getNextNode();			
		}
		System.out.print("\n");
	}
}
class LinkNode
{
	private int data;
	private LinkNode node;
	
	public LinkNode(int data)
	{
		this.data=data;
	}
	public int getData()
	{
		return data;
	}
	public void setData(int data)
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