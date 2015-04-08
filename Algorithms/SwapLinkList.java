/* Pairwise swap elements of a given linked list by changing links */

public class SwapLinkList
{
	public static void main(String[] args)
	{
		LinkList list=new LinkList();
		list.addElement(new ListNode(6));
		list.addElement(new ListNode(5));
		list.addElement(new ListNode(4));
		list.addElement(new ListNode(3));
		list.addElement(new ListNode(2));
		list.addElement(new ListNode(1));
		list.transverseList();
		list.swapListNode();
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
		if(head==null)
		{
			System.out.println("Creating Link List..");
			System.out.println("Adding Element: "+node.getData()+" on List..");
			head=node;
			node.setNextNode(null);
			return;
		}
		System.out.println("Adding Element: "+node.getData()+" on List..");
		node.setNextNode(head);
		head=node;
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
	public void swapListNode()
	{
		System.out.println("Swaping List..");
		ListNode previousNode=head;
		ListNode currentNode=head.getNextNode();
		ListNode previousPreviousNode=head;
		while(currentNode!=null)
		{
			previousNode.setNextNode(currentNode.getNextNode());
			currentNode.setNextNode(previousNode);
			if(previousPreviousNode==head)
			{
				head=currentNode;
			}
			else
			{
				previousPreviousNode.setNextNode(currentNode);
			}
			if(previousNode.getNextNode()==null)
			{
				break;				
			}
			previousPreviousNode=previousNode;
			previousNode=previousNode.getNextNode();
			currentNode=previousNode.getNextNode();
		}
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
	public ListNode getNextNode()
	{
		return node;
	}
	public void setNextNode(ListNode node)
	{
		this.node=node;
	}
	public int getData()
	{
		return data;
	}
	public void setData()
	{
		this.data=data;
	}
}