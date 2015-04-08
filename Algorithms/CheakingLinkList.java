/* Cheaking Link List if it circular link list or null terminated link list */

public class CheakingLinkList
{
	public static void main(String[] args)
	{
		CircularList list1=new CircularList();
		list1.addElement(new ListNode(5));
		list1.addElement(new ListNode(4));
		list1.addElement(new ListNode(3));
		list1.addElement(new ListNode(2));
		list1.addElement(new ListNode(1));
		list1.transverseList();
		LinkList list2=new LinkList();
		list2.addElement(new ListNode(5));
		list2.addElement(new ListNode(4));
		list2.addElement(new ListNode(3));
		list2.addElement(new ListNode(2));
		list2.addElement(new ListNode(1));
		list2.transverseList();
		CircularList mergeList=(CircularList)mergingList(list1,list2);
		boolean result1=cheakCircularity(list1);
		boolean result2=cheakCircularity(list2);
		boolean result3=cheakCircularity(mergeList);
		System.out.println(result1+" and "+result2+" and "+result3);
		
	}
	public static boolean cheakCircularity(IList list)
	{
		ListNode fastPtr=list.getHead();
		ListNode slowPtr=list.getHead();
		while(true)
		{
			fastPtr=fastPtr.getNextNode();
			if(fastPtr==null)
				return false;
			if(fastPtr==slowPtr)
				return true;
			fastPtr=fastPtr.getNextNode();
			if(fastPtr==null)
				return false;
			if(fastPtr==slowPtr)
				return true;
			slowPtr=slowPtr.getNextNode();
		}
	}
	public static IList mergingList(IList list1,IList list2)
	{
		if(cheakCircularity(list1)==false)
		{
			ListNode lastNode=list1.getHead();			
			while(lastNode.getNextNode()!=null)
			{
				lastNode=lastNode.getNextNode();
			}
			lastNode.setNextNode(list2.getHead());
			list2.setHead(list1.getHead());
			return list2;
		}
		if(cheakCircularity(list2)==false)
		{
			ListNode lastNode=list2.getHead();			
			while(lastNode.getNextNode()!=null)
			{
				lastNode=lastNode.getNextNode();
			}
			lastNode.setNextNode(list1.getHead());
			list1.setHead(list2.getHead());
			return list1;
		}
		System.out.println("Can't merge both list are circular");
		return null;
	}
}
interface IList
{
	public void setHead(ListNode node);
	public ListNode getHead();
	public void addElement(ListNode node);
	public void deleteNode(int index);
	public void transverseList();
	public int length();	
}
class LinkList implements IList
{
	private ListNode head;
	public ListNode getHead()
	{
		return head;
	}
	
	public void setHead(ListNode node)
	{
		this.head=node;
	}
	public LinkList()
	{
		head=null;
	}
	public void addElement(ListNode node)
	{
		if(head==null)
		{
			System.out.println("Creating Link list..");
			System.out.println("Adding Element: "+node.getData()+" on List...");
			head=node;
			node.setNextNode(null);
			return;
		}
		System.out.println("Adding Element: "+node.getData()+" on List...");
		node.setNextNode(head);
		head=node;
	}
	public void deleteNode(int index)
	{
		if(head==null)
		{
			System.out.println("List is Empty");
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
		while(currentNode!=null)
		{
			k++;
			currentNode=currentNode.getNextNode();
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
		}
		System.out.print("\n");
	}
	
}
class CircularList implements IList
{
	private ListNode head;
	public ListNode getHead()
	{
		return head;
	}
	public void setHead(ListNode node)
	{
		this.head=node;
	}
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