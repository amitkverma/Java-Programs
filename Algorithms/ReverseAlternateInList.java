/* Given a linked list, reverse alternate nodes and append at the end */

public class ReverseAlternateInList
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
		list.transverseList();
		list.rearrangeList();
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
			System.out.println("Adding Edlement: "+node.getData()+" to List..");
			head=node;
			node.setNextNode(null);
			return;
		}
		ListNode currentNode=head;
		while(currentNode.getNextNode()!=null)
		{
			currentNode=currentNode.getNextNode();
		}
		currentNode.setNextNode(node);
		node.setNextNode(null);
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
	public void rearrangeList()
	{
		// feacting even list
		ListNode currentNode=head;
		ListNode EvenNodeP=head.getNextNode();
		ListNode EvenNode=head.getNextNode();
		ListNode OddNode=head;
		while(currentNode!=null&&currentNode.getNextNode()!=null&&currentNode.getNextNode().getNextNode()!=null)
		{
			currentNode=currentNode.getNextNode().getNextNode();
			EvenNode.setNextNode(currentNode.getNextNode());
			EvenNode=EvenNode.getNextNode();
			OddNode.setNextNode(currentNode);
			OddNode=OddNode.getNextNode();
		}
		OddNode.setNextNode(EvenNodeP);
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