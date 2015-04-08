/* Create a Circular Link List */

public class TestCircularLinkList
{
	public static void main(String[] args)
	{
		CircularList list=new CircularList();
		list.addElement(new ListNode(5));
		list.addElement(new ListNode(4));
		list.addElement(new ListNode(3));
		list.addElement(new ListNode(2));
		list.addElement(new ListNode(1));
		list.transverseList();
		list.deleteNode(2);
		list.deleteNode(3);
		list.addElement(new ListNode(1));
		list.transverseList();
	}
}
class CircularList
{
	private ListNode head;
	public CircularList()
	{
		this.head=null;
	}
	public void addElement(ListNode node)
	{
		if(head==null)
		{
			System.out.println("Creating circular Link list..");
			System.out.println("Adding Element: "+node.getData()+" on List...");
			head=node;
			node.setNextNode(head);
			return;
		}
		ListNode lastNode=head;
		while(true)
		{
			lastNode=lastNode.getNextNode();
			if(lastNode.getNextNode()==head)
				break;
		}
		node.setNextNode(head);
		head=node;
		lastNode.setNextNode(head);
		System.out.println("Adding Element: "+node.getData()+" on List...");				
	}
	public void deleteNode(int index)
	{
		if(head==null)
		{
			System.out.println("List is empty");
			return;
		}
		if(index<length())
		{
			int i=index;
			ListNode currentNode=head;
			ListNode previousNode=null;
			while(i!=1)
			{
				previousNode=currentNode;
				currentNode=currentNode.getNextNode();
				i--;
			}
			previousNode.setNextNode(currentNode.getNextNode());
			currentNode.setNextNode(null);
			currentNode=null;
			previousNode=null;
		}
	}
	public int length()
	{
		ListNode currentNode=head;
		int k=0;
		while(true)
		{
			k++;
			currentNode=currentNode.getNextNode();
			if(currentNode==head)
				break;
		}
		return k;
	}
	public void transverseList()
	{
		ListNode currentNode=head;
		while(currentNode!=null)
		{
			System.out.print(currentNode.getData()+"->");
			currentNode=currentNode.getNextNode();
			if(currentNode==head)
				return;
		}
		System.out.println("\n");
	}
}
class ListNode
{
	private int data;
	private ListNode node;
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
		return node;
	}
	public void setData(int data)
	{
		this.data=data;
	}
	public void setNextNode(ListNode node)
	{
		this.node=node;
	}
}