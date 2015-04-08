/* Merge a linked list into another linked list at alternate positions */

public class MergeLinkList
{
	public static void main(String[] args)
	{
		LinkList list1=new LinkList();
		list1.addElement(new ListNode(5));
		list1.addElement(new ListNode(4));
		list1.addElement(new ListNode(3));
		list1.addElement(new ListNode(2));
		list1.addElement(new ListNode(1));
		list1.transverseList();
		LinkList list2=new LinkList();
		list2.addElement(new ListNode(10));
		list2.addElement(new ListNode(9));
		list2.addElement(new ListNode(8));
		list2.addElement(new ListNode(7));
		list2.addElement(new ListNode(6));
		list2.transverseList();
		MergeLinkList.MergeList(list1,list2);
		list1.transverseList();
		list2.transverseList();
	}
	public static void MergeList(LinkList list1,LinkList list2)
	{
		System.out.println("Merging List2 into List1..");
		ListNode previousNode1=list1.getHeadNode();
		ListNode previousNode2=list2.getHeadNode();
		ListNode currentNode1=previousNode1.getNextNode();
		ListNode currentNode2=previousNode2.getNextNode();
		while(previousNode1!=null&&previousNode2!=null)
		{
			previousNode1.setNextNode(previousNode2);
			previousNode2.setNextNode(currentNode1);
			list2.setHeadNode(currentNode2);
			if(currentNode1==null)
			{
				previousNode1.setNextNode(previousNode2);
				previousNode2.setNextNode(null);
				list2.setHeadNode(currentNode2);
				break;
			}
			previousNode2=currentNode2;
			currentNode2=currentNode2.getNextNode();
			previousNode1=currentNode1;
			currentNode1=currentNode1.getNextNode();			
		}
	}
}
class LinkList
{
	private ListNode head;
	
	public LinkList()
	{
		head=null;
	}
	public ListNode getHeadNode()
	{
		return head;
	}
	public void setHeadNode(ListNode node)
	{
		this.head=node;
	}
	public void addElement(ListNode node)
	{
		if(head==null)
		{
			System.out.println("Creating Link List...");
			System.out.println("Adding Element: "+node.getData()+" on List..");
			head=node;
			node.setNextNode(null);
			return;
		}
		System.out.println("Adding Element: "+node.getData()+" on List");
		node.setNextNode(head);
		head=node;
	}
	public void transverseList()
	{
		if(head==null)
		{
			System.out.println("List is Empty");
			return;
		}
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
	private ListNode node;
	public ListNode(int data)
	{
		this.data=data;
	}
	public int getData()
	{
		return data;
	}
	public void setData()
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
