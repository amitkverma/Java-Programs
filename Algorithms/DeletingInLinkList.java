/* Deleting element in singly Link list from starting,end and middile */

public class DeletingInLinkList
{
	public static void main(String[] args)
	{
		LinkList list=new LinkList();
		list.addElement(new ListNode(1));
		list.addElement(new ListNode(2));
		list.addElement(new ListNode(3));
		list.addElement(new ListNode(4));
		list.addElement(new ListNode(5));
		list.addElement(new ListNode(6));
		list.addElement(new ListNode(7));
		list.addElement(new ListNode(8));
		list.addElement(new ListNode(9));
		list.addElement(new ListNode(10));
		list.addElement(new ListNode(11));
		list.addElement(new ListNode(12));
		list.addElement(new ListNode(13));
		list.deleteElement();
		list.deleteElement();
		list.deleteElement();
		list.deleteElementLast();
		list.deleteElementLast();
		list.deleteElementLast();
		list.deleteElement(3);
		list.deleteElement(6);
		list.transverseList();
	}
}
class LinkList
{
	private ListNode head;
	public LinkList()
	{
		head=null;
	}
	public void addElement(ListNode node)
	{
		if(node!=null)
		{
			if(head==null)
			{
				System.out.println("Creating Link List...");
				System.out.println("Adding Element: "+node.getData()+" on List..");
				head=node;
				node.setNextNode(null);
				return;
			}
			System.out.println("Adding Element: "+node.getData()+" on List..");
			node.setNextNode(head);
			head=node;
		}
	}
	public void deleteElement()
	{
			if(head==null)
			{
				System.out.println("List is Empty..");
				return;
			}
			System.out.println("Deleting Element: "+head.getData()+" on List..");
			ListNode temp=head;
			head=head.getNextNode();
			temp.setNextNode(null);
			temp=null;
	}
	public void deleteElement(int position)
	{
		if(head==null)
		{
			System.out.println("List is empty..");
			return;
		}
		if(length()>position)
		{
			System.out.println("Deleting Element at "+position+" ..");
			ListNode currentNode=head;
			ListNode previousNode=currentNode;
			int k=0;
			while(k<position-1)
			{
				previousNode=currentNode;
				currentNode=currentNode.getNextNode();
				k++;
			}
			previousNode.setNextNode(currentNode.getNextNode());
			currentNode.setNextNode(null);
			currentNode=null;
		}
		else
		{
			System.out.println("please choose proper position...");
		}
	}
	public void deleteElementLast()
	{
		if(head==null)
		{
			System.out.println("List is Empty..");
			return;
		}
		System.out.println("Deleting Element..");
		ListNode previousNode=null;
		ListNode currentNode=head;
		while(currentNode.getNextNode()!=null)
		{
			previousNode=currentNode;
			currentNode=currentNode.getNextNode();
		}
		previousNode.setNextNode(null);
		currentNode=null;
	}
	public void transverseList()
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
		int k=0;
		while(currentNode!=null)
		{
			currentNode=currentNode.getNextNode();
			k++;
		}
		return k;
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
	public void setData(int data)
	{
		this.data=data;
	}
	public ListNode getNextNode()
	{
		return node;
	}
	public void setNextNode(ListNode node)
	{
		this.node=node;
	}
}