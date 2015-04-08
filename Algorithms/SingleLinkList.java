/* An Simple Link List with simple adding and deleting from starting feature */

public class SingleLinkList
{
	private ListNode head;

	public SingleLinkList()
	{
		head=null;
	}
	
	public static void main(String[] args)
	{
		SingleLinkList list=new SingleLinkList();
		list.addElement(new ListNode(4));
		list.addElement(new ListNode(7));
		list.addElement(new ListNode(1));
		list.addElement(new ListNode(3));
		list.addElement(new ListNode(8));
		list.transverseList();
		list.deleteElement();
		list.deleteElement();
		list.transverseList();
	}
	private void addElement(ListNode node) //adding item only from begining 
	{
		if(head==null)
		{
			System.out.println("Creating your Link List..");
			System.out.println("Adding item "+node.getData()+" on Link List..");
			node.setNextNode(null);
			head=node;
		}
		else
		{
			System.out.println("Adding item "+node.getData()+" on Link List..");
			node.setNextNode(head);
			head=node;		
		}
	}
	private void deleteElement() //deleting item from begining
	{
		if(head==null)
		{
			System.out.println("Link List is empty");
			return;
		}
		System.out.println("Deleting first item: "+head.getData());
		ListNode node=head;
		head=node.getNextNode();
		node.setNextNode(null);
	}
	private void transverseList()
	{
		System.out.println("your Link List is: ");
		ListNode currentNode=head;		
		while(currentNode!=null)
		{
			System.out.print(currentNode.getData()+"->");
			currentNode=currentNode.getNextNode();
		}
		System.out.print("\n");
	}
}

class ListNode
{
	private int data;
	private ListNode nextNode;
	public ListNode(int data)
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
	public ListNode getNextNode()
	{
		return nextNode;
	}
	public void setNextNode(ListNode nextNode)
	{
		this.nextNode=nextNode;
	}
}