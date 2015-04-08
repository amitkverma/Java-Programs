/* Reverse the doubly link list */

public class ReverseDoublyList
{
	public static void main(String[] args)
	{
		DoublyLinkList list =new DoublyLinkList();
		list.addElement(new ListNode(5));
		list.addElement(new ListNode(4));
		list.addElement(new ListNode(3));
		list.addElement(new ListNode(2));
		list.addElement(new ListNode(1));
		list.transverseList();
		list.reverseList(list.getHead());
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
	public void addElement(ListNode node)
	{
		if(head==null)
		{
			System.out.println("Creating Doubly link List...");
			System.out.println("Adding Element: "+node.getData()+" on list...");
			head=node;
			node.setNextNode(null);
			node.setPreviousNode(null);
			return;
		}
		System.out.println("Adding Element: "+node.getData()+" on list...");
		node.setNextNode(head);
		node.setPreviousNode(null);
		head.setPreviousNode(node);
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
	public void reverseList(ListNode node)
	{
		if(node==null)
			return;
		if(node.getNextNode()==null)
		{
			head=node;
		}
		reverseList(node.getNextNode());
		ListNode temp=node.getNextNode();
		node.setNextNode(node.getPreviousNode());
		node.setPreviousNode(temp);
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