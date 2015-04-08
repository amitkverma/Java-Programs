/* Create a doubly Link List */

public class TestDoublyLinkList
{
	public static void main(String[] args)
	{
		DoublyLinkList list=new DoublyLinkList();
		list.addElement(new ListNode(5));
		list.addElement(new ListNode(4));
		list.addElement(new ListNode(3));
		list.addElement(new ListNode(2));
		list.addElement(new ListNode(1));
		list.addElementLast(new ListNode(6));
		list.addElementLast(new ListNode(7));
		list.addElementLast(new ListNode(8));
		list.addElementLast(new ListNode(9));
		list.addElementLast(new ListNode(10));
		list.addElement(new ListNode(30),3);
		list.addElement(new ListNode(50),5);
		list.addElement(new ListNode(80),8);
		list.deleteElement(3);
		list.deleteElement(5);
		list.deleteElement(8);
		list.transverseList();
	}
}
class DoublyLinkList
{
	private ListNode head;
	public ListNode getHead()
	{
		return head;
	}
	public DoublyLinkList()
	{
		head=null;
	}
	public void addElement(ListNode node) // Adding Element from beginnig
	{
		if(head==null)
		{
			System.out.println("Creating Link list...\n Adding Element: "+node.getData()+" on list...");
			head=node;
			node.setNextNode(null);
			node.setPreviousNode(null);
			return;
		}
		System.out.println("Adding Element: "+node.getData()+" on list...");
		node.setNextNode(head);
		head.setPreviousNode(node);
		node.setPreviousNode(null);
		head=node;
	}
	public void addElement(ListNode node,int index) // adding Element at a given index
	{
		if(head==null)
		{
			System.out.println("List is Empty...");
			return;
		}
		if(index<=length())
		{
			ListNode currentNode=head;
			ListNode previousNode=null;
			int i=index;
			while(i!=1)
			{
				previousNode=currentNode;
				currentNode=currentNode.getNextNode();
				i--;
			}
			System.out.println("Adding Element: "+node.getData()+" at: "+index);
			node.setNextNode(currentNode);
			node.setPreviousNode(previousNode);
			previousNode.setNextNode(node);
			currentNode.setPreviousNode(node);
		}
		else
		{
			System.out.println("Can't put Element at this position");
		}
	}
	public void addElementLast(ListNode node) // adding element from last
	{
		if(head==null)
		{
			System.out.println("Creating a Doubly Link List..");
			System.out.println("Adding a Element: "+node.getData()+"on list...");
			head=node;
			node.setNextNode(null);
			node.setPreviousNode(null);
			return;
		}
		System.out.println("Adding an Element: "+node.getData()+"on List...");
		ListNode lastNode=head;
		while(lastNode.getNextNode()!=null)
		{
			lastNode=lastNode.getNextNode();
		}
		lastNode.setNextNode(node);
		node.setNextNode(null);
		node.setPreviousNode(lastNode);
	}
	public void transverseList() // transversing list
	{
		ListNode currentNode=head;
		while(currentNode!=null)
		{
			System.out.print(currentNode.getData()+"->");
			currentNode=currentNode.getNextNode();
		}
		System.out.print("\n");
	}
	public int length()
	{
		ListNode currentNode=head;
		int l=0;
		while(currentNode!=null)
		{
			l++;
			currentNode=currentNode.getNextNode();
		}
		return l;
	}
	public void deleteElement(int index) // deleting element at given index
	{
		ListNode currentNode=head;
		ListNode previousNode=null;
		int i=index;
		while(i!=1)
		{
			previousNode=currentNode;
			currentNode=currentNode.getNextNode();
			i--;
		}
		ListNode nextNode=currentNode.getNextNode();
		previousNode.setNextNode(currentNode.getNextNode());
		nextNode.setPreviousNode(previousNode);
		currentNode.setNextNode(null);
		currentNode.setPreviousNode(null);
	}
}
class ListNode
{
	private int data;
	private ListNode previousNode;
	private ListNode nextNode;
	public ListNode(int data)
	{
		this.data=data;
	}
	public int getData()
	{
		return data;
	}
	public ListNode getNextNode()
	{
		return nextNode;
	}
	public ListNode getPreviousNode()
	{
		return previousNode;
	}
	public void setData(int data)
	{
		this.data=data;
	}
	public void setPreviousNode(ListNode node)
	{
		this.previousNode=node;
	}
	public void setNextNode(ListNode node)
	{
		this.nextNode=node;
	}
}